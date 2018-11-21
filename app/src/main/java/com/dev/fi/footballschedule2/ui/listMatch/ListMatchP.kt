package com.dev.fi.footballschedule2.ui.listMatch

import com.dev.fi.footballschedule2.data.model.EventResponse
import com.dev.fi.footballschedule2.rest.Api
import com.dev.fi.footballschedule2.rest.Repository
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

class ListMatchP(private val view: ListMatchV,
                 private val repository: Repository,
                 private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getPrevMatchList(id: String) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getPrevMatch(id)).await(),
                    EventResponse::class.java)

            if (data.events != null) {
                view.showEventList(data.events)
                view.hideLoading()
            }
        }
    }

    fun getNextMatchList(id: String) {
        view.showLoading()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getNextMatch(id)).await(),
                    EventResponse::class.java)


            if (data.events != null) {
                view.showEventList(data.events)
                view.hideLoading()
            }
        }
    }
}