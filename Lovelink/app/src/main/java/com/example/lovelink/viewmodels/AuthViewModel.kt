package com.example.lovelink.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovelink.models.RegistrationData
import com.example.lovelink.models.RegistrationResponse
import com.example.lovelink.network.RetrofitClient
import com.example.lovelink.validation.isValidDob
import com.example.lovelink.validation.isValidEmail
import com.example.lovelink.validation.isValidHobbies
import com.example.lovelink.validation.isValidPhone
import com.example.lovelink.validation.isValidUsername
import kotlinx.coroutines.launch
import retrofit2.Response

sealed class RegistrationState {
    object Idle : RegistrationState()
    object Loading : RegistrationState()
    data class Success(val message: String) : RegistrationState()
    data class Error(val error: String) : RegistrationState()
}

class AuthViewModel : ViewModel() {
    var registrationState = mutableStateOf<RegistrationState>(RegistrationState.Idle)
        private set

    @RequiresApi(Build.VERSION_CODES.O)
    fun registerUser(username: String, email: String, phone: String,
                     gender: String, password: String, confirmPassword: String, dob: String,
                     hobbies : String, profilePicture :String, coverPhoto : String
    ) {
        // **✅ Validate user input**
        if (!isValidUsername(username)) {
            registrationState.value = RegistrationState.Error("Invalid username")
            return
        }
        if (!isValidEmail(email)) {
            registrationState.value = RegistrationState.Error("Invalid email format")
            return
        }
        if (!isValidPhone(phone)) {
            registrationState.value = RegistrationState.Error("Invalid phone number")
            return
        }
        if(!isValidHobbies(hobbies)){
            registrationState.value = RegistrationState.Error("Please fill the hobbies field")
        }
        if(isValidDob(dob)){
            registrationState.value  = RegistrationState.Error("Please fill in your Date of birth")
        }
        if (password != confirmPassword) {
            registrationState.value = RegistrationState.Error("Passwords do not match")
            return
        }

        val registrationData = RegistrationData(username, email, phone, password, dob, hobbies, profilePicture, coverPhoto)

        // Make API Call**
        viewModelScope.launch {
            registrationState.value = RegistrationState.Loading

            try {
                val response: Response<RegistrationResponse> = RetrofitClient.api.registerUser(registrationData)

                if (response.isSuccessful && response.body() != null) {
                    registrationState.value = RegistrationState.Success(response.body()!!.message)
                } else {
                    registrationState.value = RegistrationState.Error(response.errorBody()?.string() ?: "Registration failed")
                }
            } catch (e: Exception) {
                registrationState.value = RegistrationState.Error("Network error: ${e.message}")
            }
        }
    }
}
