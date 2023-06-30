package com.pl.agh.bator.ishihara_test

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.pl.agh.bator.ishihara_test.network.LeaderboardScore

@BindingAdapter("text")
fun bindRecyclerView(recyclerView: RecyclerView, data: LiveData<List<LeaderboardScore>>?) {

}