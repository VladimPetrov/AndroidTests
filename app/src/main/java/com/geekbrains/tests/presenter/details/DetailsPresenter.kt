package com.geekbrains.tests.presenter.details

import com.geekbrains.tests.view.ViewContract
import com.geekbrains.tests.view.details.ViewDetailsContract

internal class DetailsPresenter internal constructor(
    private var count: Int = 0
) : PresenterDetailsContract {

    var viewContract: ViewDetailsContract? = null

    override fun onAttach(viewContract: ViewContract) {
        this.viewContract = viewContract as ViewDetailsContract
    }

    override fun onDetach() {
        viewContract = null
    }

    override fun setCounter(count: Int) {
        this.count = count
        viewContract?.setCount(count)
    }

    override fun onIncrement() {
        count++
        viewContract?.setCount(count)
    }

    override fun onDecrement() {
        count--
        viewContract?.setCount(count)
    }
}
