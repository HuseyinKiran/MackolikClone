package com.huseyinkiran.mackolikclone.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huseyinkiran.mackolikclone.R
import com.huseyinkiran.mackolikclone.model.MatchResult
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class MatchResultAdapter(
    private val matchList: List<MatchResult>
) : RecyclerView.Adapter<MatchResultAdapter.MatchViewHolder>() {
    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamHome: TextView = itemView.findViewById(R.id.txtTeamHome)
        val teamAway: TextView = itemView.findViewById(R.id.txtTeamAway)
        val matchScore: TextView = itemView.findViewById(R.id.txtMatchScore)
        val matchDate: TextView = itemView.findViewById(R.id.txtMatchDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matchList[position]
        holder.teamHome.text = match.home
        holder.teamAway.text = match.away
        if (match.score.equals("undefined-undefined")) holder.matchScore.text =
            "BV" else holder.matchScore.text = match.score

        val dateTime = match.date?.let {
            ZonedDateTime.parse(it, DateTimeFormatter.ISO_OFFSET_DATE_TIME).plusHours(3)
        }
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yy")
        val formattedDate = dateTime?.format(dateFormatter) ?: "N/A"

        val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
        val formattedTime = dateTime?.format(timeFormatter) ?: "N/A"

        holder.matchDate.text = "$formattedDate $formattedTime"
    }
}

