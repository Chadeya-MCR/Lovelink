package com.example.lovelink.auth.registrationscreens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterScreen(
    navController: NavController
) {
    var currentStep by remember { mutableStateOf(0) }
    val totalSteps = 5
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Progress indicator at the top
        RegistrationProgressIndicator(currentStep = currentStep, totalSteps = totalSteps)
        Spacer(modifier = Modifier.height(16.dp))
        when (currentStep) {
            0 -> Step1UsernameEmailPhone(
                onNext = { currentStep++ },
                onPrevious = null,
                navController = navController
            )
            1 -> Step2Password(
                onNext = { currentStep++ },
                onPrevious = { currentStep-- }
            )
            2 -> Step3DOBHobbies(
                onNext = { currentStep++ },
                onPrevious = { currentStep-- }
            )
            3 -> Step4PhotoUpload(
                onNext = { currentStep++ },
                onPrevious = { currentStep-- }
            )
            4 -> CongratulationsScreen(navController)
        }
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    val navController = rememberNavController()
    RegisterScreen(navController = navController)
}
