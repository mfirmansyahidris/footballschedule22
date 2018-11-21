package com.dev.fi.footballschedule2.ui.listLeague

import android.annotation.SuppressLint
import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.espresso.idling.CountingIdlingResource
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.base.BaseActivity
import com.dev.fi.footballschedule2.data.model.League
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchActivity
import com.dev.fi.footballschedule2.utils.invisible
import com.dev.fi.footballschedule2.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_list_league.*

class ListLeagueActivity : BaseActivity(), ListLeagueV {
    var countingIdlingResouce = CountingIdlingResource("LISTLEAGUE")
    private var items: MutableList<League> = mutableListOf()
    private lateinit var presenter: ListLeagueP

    override fun getLayoutResource(): Int = R.layout.activity_list_league

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = getString(R.string.title_listLeagues)

    @SuppressLint("RestrictedApi")
    override fun mainCode() {
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        rv_league.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_league.layoutManager = LinearLayoutManager(this)

        val request = Repository()
        val gson = Gson()
        presenter = ListLeagueP(this, request, gson)

        presenter.getLeagueList()

    }

    override fun showLoading() {
        countingIdlingResouce.increment()
        pb_process.visible()
    }

    override fun hideLoading() {
        countingIdlingResouce.decrement()
        pb_process.invisible()
    }

    override fun showLeagueList(data: List<League>) {
        items.clear()
        items.addAll(data)
        rv_league.adapter = ListLeagueAdapter(this, items) {
            val intent = Intent(this, ListMatchActivity::class.java)
            intent.putExtra("id", it.idLeague)
            startActivity(intent)
        }
        //adapter.notifyDataSetChanged()
    }

}
