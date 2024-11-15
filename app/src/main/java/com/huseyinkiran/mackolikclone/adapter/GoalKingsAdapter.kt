package com.huseyinkiran.mackolikclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.huseyinkiran.mackolikclone.R
import com.huseyinkiran.mackolikclone.model.GoalKing

class GoalKingsAdapter(
    private var playerList: List<GoalKing>
) : RecyclerView.Adapter<GoalKingsAdapter.PlayerViewHolder>() {
    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val playerName: TextView = itemView.findViewById(R.id.txtPlayerName)
        val playerGoal: TextView = itemView.findViewById(R.id.txtPlayerGoal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cell_goal_kings, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = playerList[position]
        holder.playerName.text = player.name
        holder.playerGoal.text = player.goals
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

}

