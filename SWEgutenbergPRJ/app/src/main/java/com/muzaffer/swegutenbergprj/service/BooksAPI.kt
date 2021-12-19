package com.muzaffer.swegutenbergprj.service

import com.muzaffer.swegutenbergprj.model.BooksModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksAPI {

    @GET("books/search/The Confessions of Jean Jacques Roussea")
    fun getData (): Call<List<BooksModel>>



}