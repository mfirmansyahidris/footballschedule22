package com.dev.fi.footballschedule2.ui.listLeague

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.data.model.League

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class ListLeagueAdapter(private val context: Context, private val items: List<League>, private val listener: (League) -> Unit)
    : RecyclerView.Adapter<ListLeagueAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_league, p0, false))


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bindItem(items[p1], listener)


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val sportType = view.findViewById<TextView>(R.id.tv_sportType)
        private val leagueName = view.findViewById<TextView>(R.id.tv_LeagueName)
        private val alternateName = view.findViewById<TextView>(R.id.tv_alternateName)

        fun bindItem(items: League, listener: (League) -> Unit) {
            sportType.text = items.strSport
            leagueName.text = items.strLeague
            alternateName.text = items.strLeagueAlternate

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}