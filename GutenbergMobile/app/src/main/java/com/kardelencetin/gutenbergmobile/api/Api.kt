package com.kardelencetin.gutenbergmobile.api

import com.kardelencetin.gutenbergmobile.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("books/search")

    fun getSearchUser(
        @Query("q") query: String

    ): Call<UserResponse>


}