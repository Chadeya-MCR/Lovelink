package com.example.lovelink.models

data class LoginResponse(
    val user: User,
    val token: String,
    val message: String
)

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val hobbies : String,
    val gender :String,
    val profilePhoto : String? = null
)