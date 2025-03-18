package com.example.lovelink.network

import com.example.lovelink.models.LoginResponse
import com.example.lovelink.models.RegistrationData
import com.example.lovelink.models.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// User data class representing the user object returned in API responses
data class User(
    val username: String,
    val email: String,
    val phone : String,
    var password: String,
    var confirmPassword :String,
    val dob : String,
    val hobbies: String,
    val gender: String,
    val profilePhoto: String,
    val coverPhoto: String? = null

)

data class LoginRequest(val login: String, val password: String)

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("register")
    suspend fun registerUser(@Body request: RegistrationData): Response<RegistrationResponse>
}
