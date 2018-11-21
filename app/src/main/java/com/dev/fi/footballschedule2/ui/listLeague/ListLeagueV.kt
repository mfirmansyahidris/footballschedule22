package com.dev.fi.footballschedule2.ui.listLeague

import com.dev.fi.footballschedule2.data.model.League

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface ListLeagueV {
    fun showLoading()
    fun hideLoading()
    fun showLeagueList(data: List<League>)
}