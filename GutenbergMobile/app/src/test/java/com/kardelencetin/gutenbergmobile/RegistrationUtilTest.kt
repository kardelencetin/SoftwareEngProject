package com.kardelencetin.gutenbergmobile


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest{

    @Test
    fun `empty username returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "krdlnctn@gmail.com",
            "123"
        )
        assertThat(result).isFalse()

    }

    @Test
    fun `valid username and correctly password return true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Kardelen",
            "krdlnctn@gmail.com",
            "123"
        )
        assertThat(result).isTrue()
        //assertThat("hello").isEqualTo("hello")

    }

    @Test
    fun `username already exists return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "krdlnctn@gmail.com",
            "123"
        )
        assertThat(result).isFalse()


    }

    @Test
    fun `empty password return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "krdlnctn@gmail.com",
            ""
        )
        assertThat(result).isFalse()


    }

    @Test
    fun `less than 2 digit password return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Carl",
            "krdlnctn@gmail.com",
            "asdfg1"
        )
        assertThat(result).isFalse()


    }
}