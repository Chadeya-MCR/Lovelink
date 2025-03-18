package com.example.lovelink.models

data class RegistrationResponse(
    val user: User,
    val token: String,
    val message: String
)
