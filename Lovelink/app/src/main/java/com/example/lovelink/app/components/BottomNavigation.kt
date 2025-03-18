package com.example.lovelink.app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.lovelink.Routes

@Composable
fun BottomNavigation(
    navController: NavController,
    selectedItem: Int,
    onItemSelected: (Int) -> Unit
) {
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home"
                )},
            label = { Text("Home") },
            selected = selectedItem == 0,
            onClick = {
                navController.navigate(Routes.home_screen)
                onItemSelected(0)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.MailOutline,
                    contentDescription = "Messages"
                )},
            label = { Text("Messages") },
            selected = selectedItem == 1,
            onClick = {
                navController.navigate(Routes.messages_screen)
                onItemSelected(1)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notifications"
                )},
            label = { Text("Notifications") },
            selected = selectedItem == 2,
            onClick = {
                navController.navigate(Routes.notifications_screen)
                onItemSelected(2)
            }
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile"
                )},
            label = { Text("Profile") },
            selected = selectedItem == 3,
            onClick = {
                navController.navigate(Routes.profile_screen)
                onItemSelected(3)
            }
        )
    }
}
