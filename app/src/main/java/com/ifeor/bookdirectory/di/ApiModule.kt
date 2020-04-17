package com.ifeor.bookdirectory.di

import com.ifeor.bookdirectory.model.BooksApi
import com.ifeor.bookdirectory.model.BooksService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {
    private val BASE_URL = "https://reqres.in/api/"

    @Provides
    fun provideBooksApi(): BooksApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(BooksApi::class.java)
    }

    @Provides
    fun provideBooksService(): BooksService {
        return BooksService()
    }
}
