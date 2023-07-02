package com.pl.agh.bator.ishihara_test

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pl.agh.bator.ishihara_test.databinding.LeaderboardItemBinding
import com.pl.agh.bator.ishihara_test.network.LeaderboardScore

class LeaderboardAdapter :
    ListAdapter<LeaderboardScore, LeaderboardAdapter.LeaderboardViewHolder>(DiffCallback) {
    class LeaderboardViewHolder(private var binding: LeaderboardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(leaderboardScore: LeaderboardScore){
            binding.item = leaderboardScore
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaderboardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return LeaderboardViewHolder(
            LeaderboardItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LeaderboardViewHolder, position: Int) {
        val leaderboardItem = getItem(position)
        holder.bind(leaderboardItem)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<LeaderboardScore>() {
        override fun areItemsTheSame(oldItem: LeaderboardScore, newItem: LeaderboardScore): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LeaderboardScore, newItem: LeaderboardScore): Boolean {
            return oldItem.name == newItem.name
        }
    }
}
