package com.dev.fi.footballschedule2.ui.listLeague

import com.dev.fi.footballschedule2.data.League

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface ListLeague_V {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<League>)
}