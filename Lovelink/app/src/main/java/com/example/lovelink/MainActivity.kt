package com.example.lovelink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lovelink.app.screens.HomeScreen
import com.example.lovelink.app.screens.MessagesScreen
import com.example.lovelink.app.screens.NotificationsScreen
import com.example.lovelink.app.screens.StartUpScreen
import com.example.lovelink.app.screens.TermsOfUse
import com.example.lovelink.auth.ForgotPasswordScreen
import com.example.lovelink.auth.LoginScreen
import com.example.lovelink.auth.registrationscreens.RegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.start_up_sceen) {
                composable(Routes.start_up_sceen){
                    StartUpScreen(navController)
                }
                composable(Routes.home_screen){
                    HomeScreen(navController)
                }
                composable(Routes.login_screen){
                    LoginScreen(navController = navController)
                }
                composable(Routes.register_screen){
                    RegisterScreen(navController = navController)
                }
                composable(Routes.forgot_password){
                    ForgotPasswordScreen(navController)
                }
                composable(Routes.home_screen){
                    HomeScreen(navController)
                }
                composable(Routes.messages_screen){
                   MessagesScreen(navController)
                }
                composable(Routes.notifications_screen){
                    NotificationsScreen(navController)
                }
                composable(Routes.terms_screen){
                    TermsOfUse(navController)
                }
            }
        }
    }
}
