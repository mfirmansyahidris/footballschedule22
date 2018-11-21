package com.dev.fi.footballschedule2.ui.listLeague

import com.dev.fi.footballschedule2.TestContextProvider
import com.dev.fi.footballschedule2.data.model.League
import com.dev.fi.footballschedule2.data.model.LeagueResponse
import com.dev.fi.footballschedule2.rest.Api
import com.dev.fi.footballschedule2.rest.Repository
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * ***************************************
 * created by -manca-
 * .::manca.fi@gmail.com ::.
 * ***************************************
 */

class ListLeaguePTest {
    @Mock
    private
    lateinit var view: ListLeagueV

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var repository: Repository

    private lateinit var presenter: ListLeagueP

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = ListLeagueP(view, repository, gson, TestContextProvider())
    }

    @Test
    fun getLeagueList() {
        val leagues: MutableList<League> = mutableListOf()
        val response = LeagueResponse(leagues)


        GlobalScope.launch {
            `when`(gson.fromJson(repository
                    .doRequest(Api.getLeagues()).await(),
                    LeagueResponse::class.java
            )).thenReturn(response)

            presenter.getLeagueList()

            Mockito.verify(view).showLoading()
            Mockito.verify(view).showLeagueList(leagues)
            Mockito.verify(view).hideLoading()
        }
    }
}