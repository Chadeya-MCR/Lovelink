package com.example.lovelink.validation

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

/**
 * Validates that the username is non-empty and at least 3 characters long.
 */
fun isValidUsername(username: String): Boolean {
    return username.isNotBlank() && username.trim().length >= 3
}

/**
 * Validates that the email is non-empty and matches a regex expression.
 */
fun isValidEmail(email: String): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$".toRegex()
    return email.trim().isNotEmpty() && email.matches(emailRegex)
}

/*
* Validates that the password is non empty and has atleast 8 characters
*/
fun isValidPassword(password: String): Boolean {
    return password.isNotBlank() && password.length >= 8
}

/**
 * Validates that the phone number is non-empty and consists  of digits only.
 */
fun isValidPhone(phone: String): Boolean {
    return phone.isNotBlank() && phone.all { it.isDigit() }
}

/**
 * Validates that the date of birth is a valid date.
 * Expected format: "d/M/yyyy" (e.g., "5/9/1990" or "15/12/1985").
 */
@RequiresApi(Build.VERSION_CODES.O)
fun isValidDob(dob: String): Boolean {
    return try {
        val formatter = DateTimeFormatter.ofPattern("d/M/yyyy")
        LocalDate.parse(dob, formatter)
        true
    } catch (e: DateTimeParseException) {
        false
    }
}

/**
 * Validates that the hobbies field is non-empty and at least 3 characters long.
 */
fun isValidHobbies(hobbies: String): Boolean {
    return hobbies.isNotBlank() && hobbies.trim().length >= 3
}

/**
 * Validates that a profile picture has been provided.
 * (Here, we assume that a valid profile picture is represented by a non-empty file path or URL.)
 */
fun isValidProfilePicture(profilePicturePath: String): Boolean {
    return profilePicturePath.isNotBlank()
}

/**
 * Validates that a cover photo has been provided.
 */
fun isValidCoverPhoto(coverPhotoPath: String): Boolean {
    return coverPhotoPath.isNotBlank()
}
