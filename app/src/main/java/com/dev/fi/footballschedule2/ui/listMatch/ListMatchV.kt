package com.dev.fi.footballschedule2.ui.listMatch

import com.dev.fi.footballschedule2.data.model.Event

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

interface ListMatchV {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Event>)
}