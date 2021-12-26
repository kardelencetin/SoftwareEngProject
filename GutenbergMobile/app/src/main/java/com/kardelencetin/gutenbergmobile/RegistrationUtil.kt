package com.kardelencetin.gutenbergmobile

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    fun validateRegistrationInput(
        username: String,
        mail: String,
        password: String

    ): Boolean{
        if (username.isEmpty() || password.isEmpty() ||mail.isEmpty()){
            return false
        }
        if (username in existingUsers){
            return false
        }
        if (password.count { it.isDigit() } < 2){
            return false
        }
        return true
    }
}