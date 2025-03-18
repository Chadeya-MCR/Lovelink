package com.example.lovelink.auth.registrationscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lovelink.Routes

// NavigationButtons is assumed to be defined and imported elsewhere.

@Composable
fun Step1UsernameEmailPhone(
    navController: NavController,
    onNext: () -> Unit,
    onPrevious: (() -> Unit)?
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Who Are You? Let's Discover!",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Info Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Your info personalizes your experience.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Input fields
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("What's your username ?", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "Username Icon")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                textStyle = TextStyle(fontSize = 20.sp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Gray
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("What's your email ?", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Email, contentDescription = "Email Icon")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Gray
                )
            )
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("What's your phone number ?", color = Color.Gray) },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Phone, contentDescription = "Phone Icon")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                singleLine = true,
                textStyle = TextStyle(fontSize = 20.sp),
                shape = RoundedCornerShape(10.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Gray,
                    unfocusedIndicatorColor = Color.Gray,
                    cursorColor = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Select your gender",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { selectedGender = "Male" },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedGender == "Male") Color.Red else Color.LightGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Male",
                        color = if (selectedGender == "Male") Color.White else Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { selectedGender = "Female" },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedGender == "Female") Color.Red else Color.LightGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Female",
                        color = if (selectedGender == "Female") Color.White else Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { selectedGender = "Others" },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (selectedGender == "Others") Color.Red else Color.LightGray
                    ),
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Others",
                        color = if (selectedGender == "Others") Color.White else Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Already have an account? ",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray
                )
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Red,
                    modifier = Modifier.clickable {
                        navController.navigate(Routes.login_screen)
                    }
                )
            }
        }
        // Spacer pushes the navigation buttons to the bottom
        Spacer(modifier = Modifier.weight(1f))
        // Navigation buttons row at the bottom
        NavigationButtons(
            onPrevious = onPrevious,
            onNext = onNext
        )
    }
}
