package com.dev.fi.footballschedule2.ui.listLeague

import com.dev.fi.footballschedule2.rest.Api
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.data.LeagueResponse
import com.dev.fi.footballschedule2.utils.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class ListLeague_P(private val view: ListLeague_V,
                   private val repository: Repository,
                   private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getLeagueList() {
        view.showLoading()

        GlobalScope.launch (context.main){
            val data = gson.fromJson(repository
                    .doRequest(Api.getLeagues()).await(),
                    LeagueResponse::class.java)

            view.showLeagueList(data.leagues)
            view.hideLoading()
        }
    }
}