package com.dev.fi.footballschedule2.ui.listLeague

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.base.BaseActivity
import com.dev.fi.footballschedule2.data.League
import com.dev.fi.footballschedule2.rest.Repository
import com.dev.fi.footballschedule2.utils.invisible
import com.dev.fi.footballschedule2.utils.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_list_league.*

class ListLeagueActivity : BaseActivity(), ListLeague_V {
    private var items: MutableList<League> = mutableListOf()
    private lateinit var presenter: ListLeague_P
    private lateinit var adapter: ListLeagueAdapter

    override fun getLayoutResource(): Int = R.layout.activity_list_league

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = getString(R.string.title_listLeague)

    @SuppressLint("RestrictedApi")
    override fun mainCode() {
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        rv_league.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_league.layoutManager = LinearLayoutManager(this)

        val request = Repository()
        val gson = Gson()
        presenter = ListLeague_P(this, request, gson)

        presenter.getLeagueList()

    }

    override fun showLoading() {
        pb_process.visible()
    }

    override fun hideLoading() {
        pb_process.invisible()
    }

    override fun showLeagueList(data: List<League>) {
        items.clear()
        items.addAll(data)
        rv_league.adapter = ListLeagueAdapter(this, items) {}
        //adapter.notifyDataSetChanged()
    }

}
