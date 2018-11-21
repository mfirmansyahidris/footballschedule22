package com.dev.fi.footballschedule2.ui.detailMatch

import com.dev.fi.footballschedule2.data.model.Team
import com.dev.fi.footballschedule2.data.model.TeamResponse
import com.dev.fi.footballschedule2.rest.Api
import com.dev.fi.footballschedule2.rest.Repository
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

/**
 * ***************************************
 * created by -manca-
 * .::manca.fi@gmail.com ::.
 * ***************************************
 */

class DetailMatchPTest {
    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var repository: Repository

    @Test
    fun getTeamDetail() {
        val id = "133616"
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)

        GlobalScope.launch {
            Mockito.`when`(gson.fromJson(repository
                    .doRequest(Api.getTeamDetail(id)).await(),
                    TeamResponse::class.java
            )).thenReturn(response)
        }
    }
}