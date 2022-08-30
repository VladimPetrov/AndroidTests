package com.geekbrains.tests

import com.geekbrains.tests.model.SearchResponse
import com.geekbrains.tests.model.SearchResult
import com.geekbrains.tests.presenter.details.DetailsPresenter
import com.geekbrains.tests.presenter.search.SearchPresenter
import com.geekbrains.tests.repository.GitHubApi
import com.geekbrains.tests.repository.GitHubRepository
import com.geekbrains.tests.view.details.ViewDetailsContract
import com.geekbrains.tests.view.search.ViewSearchContract
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import retrofit2.Response


class DetailsPresenterTest {

    private lateinit var presenter: DetailsPresenter

    @Mock
    private lateinit var viewContract: ViewDetailsContract


    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

        presenter = DetailsPresenter()
        presenter.onAttach(viewContract)
    }

    @Test
    fun onAttach_Test() {
        assertNotNull(presenter.viewContract)
    }

    @Test
    fun onDetach_Test() {
        presenter.onDetach()
        assertNull(presenter.viewContract)
    }

    @Test
    fun setCounter_Test() {
        val testCount = 32
        presenter.setCounter(testCount)
        verify(viewContract, times(1)).setCount(testCount)
    }

    @Test
    fun onIncrement_Test() {
        presenter.onIncrement()
        verify(viewContract, times(1)).setCount(1)
    }

    @Test
    fun onDecrement_Test() {
        presenter.onDecrement()
        verify(viewContract, times(1)).setCount(-1)
    }

}
