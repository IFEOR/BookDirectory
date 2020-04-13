package com.ifeor.bookdirectory.ui.favorites

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface FavoritesView : MvpView {

    fun showNoDataText()
}
