package com.ifeor.bookdirectory.ui.search

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ifeor.bookdirectory.R
import kotlinx.android.synthetic.main.fragment_search.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SearchFragment : MvpAppCompatFragment(), SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    private val booksAdapter = BookListAdapter(arrayListOf())

    override fun showNoDataText() {
        fragment_search_textview.text = (R.string.fragment_search_no_data_text).toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.refresh()
        book_recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
        }
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            presenter.refresh()
        }
        observePresenter()
    }

    private fun observePresenter() {
        presenter.books.observe(this, Observer { countries ->
            countries?.let {
                book_recycler.visibility = View.VISIBLE
                booksAdapter.updateBooks(it)
            }
        })
        presenter.bookLoadError.observe(this, Observer { isError ->
            isError?.let { fragment_search_error.visibility = if (it) View.VISIBLE else View.GONE }
        })
        presenter.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                fragment_search_loading.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    fragment_search_error.visibility = View.GONE
                    book_recycler.visibility = View.GONE
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.filter_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_all -> {
                // TODO in backend
                return true
            }
            R.id.menu_author -> {
                // TODO in backend
                return true
            }
            R.id.menu_name -> {
                // TODO in backend
                return true
            }
            R.id.menu_genre -> {
                // TODO in backend
                return true
            }
            R.id.menu_edition -> {
                // TODO in backend
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
