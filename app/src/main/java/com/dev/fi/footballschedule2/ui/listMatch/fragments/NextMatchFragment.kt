package com.dev.fi.footballschedule2.ui.listMatch.fragments

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.base.BaseFragment
import com.dev.fi.footballschedule2.data.model.Event
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchActivity.Companion.nextMatchCountingIdlingResource
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchAdapter
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchP
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchV
import com.dev.fi.footballschedule2.utils.invisible
import com.dev.fi.footballschedule2.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class NextMatchFragment: BaseFragment(), ListMatchV {
    private var items: MutableList<Event> = mutableListOf()
    private lateinit var presenter: ListMatchP
    override fun getLayoutResource(): Int = R.layout.fragment_match

    override fun mainCode() {

        rv_match.id = R.id.rv_match_next
        rv_match.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_match.layoutManager = LinearLayoutManager(activity)

        val request = Repository()
        val gson = Gson()
        presenter = ListMatchP(this, request, gson)


        val id = activity.intent.getStringExtra("id")
        presenter.getNextMatchList(id)

    }

    override fun showLoading() {
        nextMatchCountingIdlingResource.increment()
        pb_process.visible()
    }

    override fun hideLoading() {
        nextMatchCountingIdlingResource.decrement()
        pb_process.invisible()
    }

    override fun showEventList(data: List<Event>) {
        items.clear()
        items.addAll(data)
        rv_match.adapter = ListMatchAdapter(activity, items) {
            val intent = Intent(activity, DetailMatchActivity::class.java)
            intent.putExtra("event", it)
            startActivity(intent)
        }
    }

}