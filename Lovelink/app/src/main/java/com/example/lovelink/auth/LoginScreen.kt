package com.example.lovelink.auth

import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lovelink.Routes
import com.example.lovelink.network.RetrofitClient
import com.example.lovelink.network.LoginRequest
import com.example.lovelink.validation.isValidEmail
import com.example.lovelink.validation.isValidPassword
import com.example.lovelink.validation.isValidUsername
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    var loginInput by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var loginError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val path = Path().apply {
                moveTo(0f, size.height * 0.3f)
                cubicTo(
                    size.width * 0.3f, size.height * 0.5f,
                    size.width * 0.5f, size.height * 0.2f,
                    size.width, size.height * 0.35f
                )
                lineTo(size.width, 0f)
                lineTo(0f, 0f)
                close()
            }
            drawPath(path, color = Color.Red)
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))

            Box(
                modifier = Modifier.size(90.dp).clip(CircleShape).background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "User Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(60.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("Welcome Back", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(100.dp))

            OutlinedTextField(
                value = loginInput,
                onValueChange = { loginInput = it; loginError = "" },
                label = { Text(text = "Username or Email", color = Color.Gray) },
                leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Login Icon") },
                modifier = Modifier.fillMaxWidth().padding(top  = 50.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Gray
                )
            )
            if (loginError.isNotEmpty()) {
                Text(text = loginError, color = Color.Red, fontSize = 14.sp, modifier = Modifier.align(Alignment.Start).padding(start = 16.dp))
            }
            Spacer(modifier = Modifier.height(6.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it; passwordError = "" },
                label = { Text(text = "Password", color = Color.Gray) },
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "Lock Icon") },
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(fontSize = 20.sp),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.Gray,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                )
            )
            if (passwordError.isNotEmpty()) {
                Text(text = passwordError, color = Color.Red, fontSize = 14.sp, modifier = Modifier.align(Alignment.Start).padding(start = 16.dp))
            }
            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = { navController.navigate(Routes.forgot_password) },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Forgot Password ?", style = MaterialTheme.typography.labelMedium)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    val isEmailInput = loginInput.contains("@")
                    if (isEmailInput && !isValidEmail(loginInput)) {
                        loginError = "Invalid email address"
                    } else if (!isEmailInput && !isValidUsername(loginInput)) {
                        loginError = "Invalid username"
                    }
                    //if (!isValidPassword(password)) {
                       // passwordError = "Password must be at least 8 characters"
                   // }

                    if (loginError.isEmpty() && passwordError.isEmpty()) {
                        coroutineScope.launch {
                            isLoading = true
                            try {
                                val response = RetrofitClient.api.login(LoginRequest(loginInput, password))
                                if (response.isSuccessful) {
                                    val token = response.body()?.token ?: ""
                                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                                    navController.navigate(Routes.home_screen)
                                } else {
                                    Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT).show()
                                }
                            } catch (e: Exception) {
                                Toast.makeText(context, "Network Error: ${e.message}", Toast.LENGTH_SHORT).show()
                            } finally {
                                isLoading = false
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                if (isLoading) {
                    CircularProgressIndicator(color = Color.White)
                } else {
                    Text(text = "Sign In", color = Color.White, fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Text("Don't have an account? ", color = Color.Gray)
                Text(
                    text = "Create",
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { navController.navigate(Routes.register_screen) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = rememberNavController())
}
