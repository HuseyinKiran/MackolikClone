package com.huseyinkiran.mackolikclone.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huseyinkiran.mackolikclone.util.LeagueImageProvider
import com.huseyinkiran.mackolikclone.R
import com.huseyinkiran.mackolikclone.model.League

class LeagueAdapter(
    private var leagueList: List<League>,
    private val onItemClick: (League) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val leagueName: TextView = itemView.findViewById(R.id.txtLeagueName)
        val imgLeagueLogo: ImageView = itemView.findViewById(R.id.imgFlag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_league, parent, false)
        return LeagueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = leagueList[position]
        holder.leagueName.text = league.league
        holder.imgLeagueLogo.setImageResource(LeagueImageProvider.getImageResource(league.key))

        holder.itemView.setOnClickListener {
            onItemClick(league)
        }
    }

    override fun getItemCount(): Int {
        return leagueList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<League>) {
        leagueList = newList
        notifyDataSetChanged()
    }

}

