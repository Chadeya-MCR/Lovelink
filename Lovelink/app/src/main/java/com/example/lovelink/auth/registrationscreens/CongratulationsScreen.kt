package com.example.lovelink.auth.registrationscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lovelink.R
import com.example.lovelink.Routes

// Congratulations Screen
@Composable
fun CongratulationsScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.congratulations),
            contentDescription = "Congratulations Image",
            modifier = Modifier.size(300.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Congratulations!",
            style = MaterialTheme.typography.headlineLarge,
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your account has been created",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(70.dp))

        TextButton(
            onClick = { navController.navigate(Routes.login_screen) },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .border(1.dp, Color.Red, shape = RoundedCornerShape(20.dp)),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(
                text = "Sign in",
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 10.dp),
                color = Color.Gray
            )
        }

    }
}
