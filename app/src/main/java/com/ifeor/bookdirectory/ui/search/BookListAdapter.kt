package com.ifeor.bookdirectory.ui.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ifeor.bookdirectory.R
import com.ifeor.bookdirectory.model.Book
import com.ifeor.bookdirectory.util.setImagePlaceholder
import kotlinx.android.synthetic.main.item_book.view.*

class BookListAdapter(private var books: ArrayList<Book>) :
    RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {

    fun updateBooks(newBooks: List<Book>) {
        books.clear()
        books.addAll(newBooks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = BookViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
    )

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(books[position])
    }

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.item_book_image
        private val authorName = view.item_author_name
        private val bookName = view.item_book_name
        @SuppressLint("SetTextI18n")
        fun bind(country: Book) {
            authorName.text = country.firstAuthorName + " " + country.lastAuthorName
            bookName.text = country.name
            imageView.setImagePlaceholder(country.image)
        }
    }
}
