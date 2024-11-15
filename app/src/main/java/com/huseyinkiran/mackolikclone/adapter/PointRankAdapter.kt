package com.huseyinkiran.mackolikclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huseyinkiran.mackolikclone.R
import com.huseyinkiran.mackolikclone.model.LeagueStanding

class PointRankAdapter(
    private val teamList: List<LeagueStanding>
) : RecyclerView.Adapter<PointRankAdapter.TeamsViewHolder>() {
    class TeamsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamRank: TextView = itemView.findViewById(R.id.txtTeamRank)
        val teamName: TextView = itemView.findViewById(R.id.txtTeamName)
        val teamWin: TextView = itemView.findViewById(R.id.txtTeamWin)
        val teamLose: TextView = itemView.findViewById(R.id.txtTeamLose)
        val teamPlay: TextView = itemView.findViewById(R.id.txtTeamPlay)
        val teamDraw: TextView = itemView.findViewById(R.id.txtTeamDraw)
        val teamGoalScored: TextView = itemView.findViewById(R.id.txtTeamGoalScored)
        val teamGoalConceded: TextView = itemView.findViewById(R.id.txtTeamGoalConceded)
        val teamAverage: TextView = itemView.findViewById(R.id.txtTeamAverage)
        val teamPoint: TextView = itemView.findViewById(R.id.txtTeamPoint)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cell_teams, parent, false)
        return TeamsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val team = teamList[position]
        holder.teamRank.text = team.rank.toString()
        holder.teamName.text = team.team
        holder.teamPoint.text = team.point.toString()
        holder.teamWin.text = team.win.toString()
        holder.teamLose.text = team.lose.toString()
        holder.teamPlay.text = team.play.toString()
        holder.teamDraw.text = team.draw.toString()
        holder.teamGoalScored.text = team.goalFor.toString()
        holder.teamGoalConceded.text = team.goalAgainst.toString()
        holder.teamAverage.text = team.goalDistance.toString()
    }
}

