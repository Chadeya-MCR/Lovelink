package com.example.lovelink.app.screens

import android.graphics.Color.RED
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lovelink.Routes
import com.example.lovelink.R

@Composable
fun StartUpScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(RED)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Add the logo image at the top
            //Image(
                //painter = painterResource(id = R.drawable.logo), // Ensure R.drawable.logo exists
               // contentDescription = "App Logo",
              //  modifier = Modifier.size(100.dp)
            //)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome to LoveLink",
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Connect With your soulmate Today!",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = White,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(350.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(25.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "By signing up, you agree to the ",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                    TextButton(
                        onClick = { navController.navigate(Routes.terms_screen) },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            "Terms of Use",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold
                            ),
                            textDecoration = TextDecoration.Underline,
                            color = MaterialTheme.colorScheme.onPrimary,
                        )
                    }
                }
                ElevatedButton(
                    onClick = { navController.navigate(Routes.register_screen) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation()
                ) {
                    Text(
                        text = "Sign up",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                        color = Red,
                    )
                }
                TextButton(
                    onClick = { navController.navigate(Routes.login_screen) }
                ) {
                    Text(
                        text = "Login",
                        color = White,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLandingPage(){
    StartUpScreen(navController = rememberNavController())
}
