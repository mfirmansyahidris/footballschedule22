package com.dev.fi.footballschedule2.ui.listMatch

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.data.model.Event
import com.dev.fi.footballschedule2.utils.reformatDate

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class ListMatchAdapter(private val context: Context, private val items: List<Event>, private val listener: (Event) -> Unit)
    : RecyclerView.Adapter<ListMatchAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, p0, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bindItem(items[p1], listener)


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvDateEvent = view.findViewById<TextView>(R.id.tv_dateEvent)
        private val tvTeamHome = view.findViewById<TextView>(R.id.tv_teamHome)
        private val tvTeamHomeScore = view.findViewById<TextView>(R.id.tv_teamHomeScore)
        private val tvTeamAwayScore = view.findViewById<TextView>(R.id.tv_teamAwayScore)
        private val tvTeamAway = view.findViewById<TextView>(R.id.tv_teamAway)

        fun bindItem(items: Event, listener: (Event) -> Unit) {
            tvDateEvent.text = reformatDate(items.dateEvent)
            tvTeamHome.text = items.strHomeTeam
            tvTeamHomeScore.text = items.intHomeScore
            tvTeamAwayScore.text = items.intAwayScore
            tvTeamAway.text = items.strAwayTeam

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}