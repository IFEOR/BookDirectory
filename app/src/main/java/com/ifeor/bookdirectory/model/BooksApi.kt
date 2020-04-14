package com.ifeor.bookdirectory.model

import io.reactivex.Single
import retrofit2.http.GET

interface BooksApi {
    @GET("users")
    fun getBooks(): Single<Directory>
}
