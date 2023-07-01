package com.pl.agh.bator.ishihara_test

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pl.agh.bator.ishihara_test.network.LeaderboardScore

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<LeaderboardScore>?
) {
    val adapter = recyclerView.adapter as LeaderboardAdapter
    adapter.submitList(data)
}