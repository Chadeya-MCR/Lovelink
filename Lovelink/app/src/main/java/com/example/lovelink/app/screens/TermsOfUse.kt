package com.example.lovelink.app.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TermsOfUse(navController: NavController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "Terms of Use",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontSize = 20.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Welcome to LoveLink, the dating app that connects you with like-minded individuals seeking genuine connections. By using this app, you agree to the following terms:",
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(8.dp))
            TermItem(
                title = "Accurate Information",
                description = "You are responsible for providing accurate and up-to-date personal information."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "Respectful Interactions",
                description = "Treat all users with respect and refrain from any harassment or offensive behavior."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "Content Moderation",
                description = "LoveLink reserves the right to remove or modify any content that violates our guidelines."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "User Safety",
                description = "Exercise caution in all interactions and report any suspicious behavior."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "Prohibited Activities",
                description = "Do not use the app for any unlawful purposes or fraudulent activities."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "Updates to Terms",
                description = "These terms may change over time. Continued use of LoveLink means you accept the changes."
            )
            Spacer(modifier = Modifier.height(4.dp))
            TermItem(
                title = "Privacy",
                description = "Review our Privacy Policy to understand how your data is collected and used."
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Row with Checkbox and final disclaimer text
            var termsAccepted by remember { mutableStateOf(false) }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = termsAccepted,
                    onCheckedChange = { termsAccepted = it }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "By using LoveLink, you confirm that you have read, understood, and agree to these terms.",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
fun TermItem(title: String, description: String) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TermsOfUsePreview() {
    TermsOfUse(navController = rememberNavController())
}
