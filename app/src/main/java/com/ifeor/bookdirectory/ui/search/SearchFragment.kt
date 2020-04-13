package com.ifeor.bookdirectory.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ifeor.bookdirectory.R
import kotlinx.android.synthetic.main.fragment_search.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class SearchFragment : MvpAppCompatFragment(), SearchView {

    @InjectPresenter
    lateinit var presenter: SearchPresenter

    override fun showNoDataText() {
        id_fragment_search_textview.text = (R.string.fragment_search_no_data_text).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }
}
