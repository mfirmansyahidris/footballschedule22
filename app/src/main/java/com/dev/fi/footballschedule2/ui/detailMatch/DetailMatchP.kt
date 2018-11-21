package com.dev.fi.footballschedule2.ui.detailMatch

import android.view.View
import android.widget.ImageView
import com.dev.fi.footballschedule2.data.model.Event
import com.dev.fi.footballschedule2.data.model.TeamResponse
import com.dev.fi.footballschedule2.rest.Api
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.ui.detailMatch.DetailMatchActivity.Companion.detailCountingIdlingResouce
import com.dev.fi.footballschedule2.utils.CoroutineContextProvider
import com.dev.fi.footballschedule2.utils.invisible
import com.dev.fi.footballschedule2.utils.visible
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class DetailMatchP(private val view: DetailMatchV, private val repository: Repository,
                   private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getDetail(data: Event) {
        view.showDetail(data)
    }

    fun loadTeamDetail(id: String, placeholder: View, image: ImageView) {
        placeholder.visible()
        detailCountingIdlingResouce.increment()
        GlobalScope.launch(context.main) {
            val data = gson.fromJson(repository
                    .doRequest(Api.getTeamDetail(id)).await(),
                    TeamResponse::class.java)

            val url = data.teams[0].strTeamBadge.toString()
            if (url != null) Picasso.get().load(url).into(image)
            placeholder.invisible()
            detailCountingIdlingResouce.decrement()
        }
    }

}