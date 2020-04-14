package com.ifeor.bookdirectory.di

import com.ifeor.bookdirectory.model.BooksService
import com.ifeor.bookdirectory.ui.search.SearchPresenter
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service: BooksService)
    fun inject (presenter: SearchPresenter)
}
