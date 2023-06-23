package com.pl.agh.bator.ishihara_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class LeaderboardAdapter (private val dataset: List<LeaderboardScore>) : RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder>() {
    class LeaderboardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val itemView: ConstraintLayout = view.findViewById(R.id.leaderboard_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.leaderboard_item, parent, false)
        return LeaderboardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val score = dataset[position]
        holder.itemView.findViewById<TextView>(R.id.place_and_name).text =
            "${score.position}. ${score.name}"
        holder.itemView.findViewById<TextView>(R.id.score).text =
            "${score.score}"
    }
}
