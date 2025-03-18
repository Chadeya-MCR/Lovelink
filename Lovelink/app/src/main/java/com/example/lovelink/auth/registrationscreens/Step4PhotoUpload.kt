package com.example.lovelink.auth.registrationscreens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts.GetContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


// NavigationButtons is assumed to be already defined and imported.

@Composable
fun Step4PhotoUpload(
    onNext: () -> Unit,
    onPrevious: () -> Unit
) {
    // States to hold the selected image URIs
    var profilePhotoUri by remember { mutableStateOf<Uri?>(null) }
    var coverPhotoUri by remember { mutableStateOf<Uri?>(null) }

    // Launchers to pick an image from the gallery
    val profilePhotoPicker = rememberLauncherForActivityResult(contract = GetContent()) { uri: Uri? ->
        profilePhotoUri = uri
    }
    val coverPhotoPicker = rememberLauncherForActivityResult(contract = GetContent()) { uri: Uri? ->
        coverPhotoUri = uri
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top section: Heading, explanation and photo placeholders
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Capture Your Essence",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Using Person icon as a placeholder for explanation.
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Info Icon",
                    tint = Color.Gray,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Upload at least two photos to complete your profile.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                // Profile Photo Picker
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                        .clickable { profilePhotoPicker.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    if (profilePhotoUri != null) {
                        AsyncImage(
                            model = profilePhotoUri,
                            contentDescription = "Profile Photo",
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            androidx.compose.material3.Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add Photo",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = "Add Photo",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
                // Cover Photo Picker
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                        .clickable { coverPhotoPicker.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    if (coverPhotoUri != null) {
                        AsyncImage(
                            model = coverPhotoUri,
                            contentDescription = "Cover Photo",
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            androidx.compose.material3.Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = "Add Photo",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = "Add Photo",
                                color = Color.Gray,
                                fontSize = 16.sp
                            )
                        }
                    }
                }
            }
        }
        // Spacer pushes the navigation buttons to the bottom
        Spacer(modifier = Modifier.weight(1f))
        // Navigation buttons row (imported NavigationButtons)
        NavigationButtons(
            onPrevious = onPrevious,
            onNext = onNext,
            nextText = "Finish"
        )
    }
}
