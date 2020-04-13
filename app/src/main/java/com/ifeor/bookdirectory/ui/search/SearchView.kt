package com.ifeor.bookdirectory.ui.search

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface SearchView : MvpView {

    fun showNoDataText()
}
