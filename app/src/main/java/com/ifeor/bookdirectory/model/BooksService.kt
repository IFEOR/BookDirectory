package com.ifeor.bookdirectory.model

import com.ifeor.bookdirectory.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class BooksService {
    @Inject
    lateinit var api: BooksApi

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getBooks(): Single<Directory> {
        return api.getBooks()
    }
}
