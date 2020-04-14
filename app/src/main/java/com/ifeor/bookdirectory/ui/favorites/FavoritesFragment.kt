package com.ifeor.bookdirectory.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ifeor.bookdirectory.R
import kotlinx.android.synthetic.main.fragment_favorites.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class FavoritesFragment : MvpAppCompatFragment(), FavoritesView {

    @InjectPresenter
    lateinit var presenter: FavoritesPresenter

    override fun showNoDataText() {
        fragment_favorites_textview.text = (R.string.fragment_favorites_no_data_text).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }
}
