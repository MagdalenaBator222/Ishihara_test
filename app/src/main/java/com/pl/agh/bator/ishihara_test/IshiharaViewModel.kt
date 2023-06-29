package com.pl.agh.bator.ishihara_test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pl.agh.bator.ishihara_test.network.LeaderboardApi
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [LeaderboardFragment] (for now).
 */
class IshiharaViewModel : ViewModel() {

    private val _scores = MutableLiveData<List<LeaderboardScore>>()
    val scores : LiveData<List<LeaderboardScore>> = _scores

    init {
        viewModelScope.launch {
            _scores.value = LeaderboardApi.retrofitService.getLeaderboard()
        }
    }

}