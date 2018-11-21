package com.dev.fi.footballschedule2.ui.listMatch.fragments

import android.content.Intent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.base.BaseFragment
import com.dev.fi.footballschedule2.data.model.Event
import com.dev.fi.footballschedule2.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchAdapter
import com.dev.fi.footballschedule2.utils.data.DataFavorite
import kotlinx.android.synthetic.main.fragment_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class FavoriteMatchFragment : BaseFragment() {
    private var items: List<Event> = mutableListOf()
    override fun getLayoutResource(): Int = R.layout.fragment_match

    override fun mainCode() {
        rv_match.id = R.id.rv_match_favorite
        rv_match.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        rv_match.layoutManager = LinearLayoutManager(activity)

        initData()

    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {
        items = emptyList()
        items = DataFavorite.getDatas(activity)
        rv_match.adapter = ListMatchAdapter(activity, items) {
            val intent = Intent(activity, DetailMatchActivity::class.java)
            intent.putExtra("event", it)
            startActivity(intent)
        }
    }

}