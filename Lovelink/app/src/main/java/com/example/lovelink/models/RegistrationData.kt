package com.example.lovelink.models

data class RegistrationData(
    var username: String = "",
    var email: String = "",
    var phone: String = "",
    var gender: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    var dob: String = "",
    var hobbies: String = "",
    var profilePicture: String = "",
    var coverPhoto: String = ""
)
