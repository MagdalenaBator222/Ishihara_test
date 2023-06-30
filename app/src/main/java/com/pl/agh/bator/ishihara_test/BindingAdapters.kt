package com.pl.agh.bator.ishihara_test

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView, data: LiveData<List<LeaderboardScore>>?
) {
    val adapter = recyclerView.adapter as LeaderboardAdapter
    //
}