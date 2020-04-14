package com.ifeor.bookdirectory.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("avatar")
    val image: String,
    @SerializedName("email")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("first_name")
    val firstAuthorName: String,
    @SerializedName("last_name")
    val lastAuthorName: String
)
