package com.ifeor.bookdirectory.ui.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ifeor.bookdirectory.di.DaggerApiComponent
import com.ifeor.bookdirectory.model.Book
import com.ifeor.bookdirectory.model.BooksService
import com.ifeor.bookdirectory.model.Directory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class SearchPresenter : MvpPresenter<SearchView>() {
    @Inject
    lateinit var booksService: BooksService

    init {
        DaggerApiComponent.create().inject(this)
    }

    private val disposable = CompositeDisposable()
    val books = MutableLiveData<List<Book>>()
    val bookLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchBooks()
    }

    private fun fetchBooks() {
        loading.value = true
        disposable.add(
            booksService.getBooks()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Directory>() {
                    override fun onSuccess(directory: Directory) {
                        Log.d("Loading error", "" + directory)
                        books.value = directory.books
                        bookLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        bookLoadError.value = true
                        loading.value = false
                        Log.d("Loading error ", "" + e.printStackTrace())
                    }
                })
        )
    }
}
