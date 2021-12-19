package com.muzaffer.swegutenbergprj.model

import com.google.gson.annotations.SerializedName

data class BooksModel(

    @SerializedName("title") //title
    val title: String,
    @SerializedName("subtitle") //subtitle
    val subtitle: String,
    @SerializedName("image") //image
    val image : String,
    @SerializedName("Language")
    val Language: String,
    @SerializedName ("Subject")
    val Subject: String



)
