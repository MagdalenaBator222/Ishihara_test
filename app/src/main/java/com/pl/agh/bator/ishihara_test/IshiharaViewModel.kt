package com.pl.agh.bator.ishihara_test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pl.agh.bator.ishihara_test.data.Datasource
import com.pl.agh.bator.ishihara_test.data.IshiharaPlate
import com.pl.agh.bator.ishihara_test.data.answerMeaning
import com.pl.agh.bator.ishihara_test.databinding.FragmentLeaderboardBinding
import com.pl.agh.bator.ishihara_test.databinding.FragmentLoopVersusBinding
import com.pl.agh.bator.ishihara_test.network.LeaderboardApi
import com.pl.agh.bator.ishihara_test.network.LeaderboardScore
import kotlinx.coroutines.launch

/**
 * The [ViewModel] that is attached to the [LeaderboardFragment] (for now).
 */


class IshiharaViewModel : ViewModel() {
    var MAX_NO_OF_PLATES = 102
    val VERSUS_COUNT = 10
    val TEST_COUNT = 38
    val SCORE_DECREASE = 7

    private val _scores = MutableLiveData<List<LeaderboardScore>>()
    val scores : LiveData<List<LeaderboardScore>> = _scores

    private val _currentScore = MutableLiveData<Float>(100f)
    val currentScore: LiveData<Float>
        get() = _currentScore

    private val _currentAnswerCount = MutableLiveData<Int>(0)
    val currentAnswerCount: LiveData<Int>
        get() = _currentAnswerCount

    private var platesList: MutableList<IshiharaPlate> = mutableListOf()

    private val _currentPlate = MutableLiveData<IshiharaPlate>()
    val currentPlate: LiveData<IshiharaPlate>
        get() = _currentPlate

    private var _binding: FragmentLoopVersusBinding? = null
    private val binding get() = _binding!! // get-only property

    private var _answerOrder: List<Int> = listOf()

    fun getNextPlate() {
        _currentPlate.value = platesList[currentAnswerCount.value!!]
        _currentAnswerCount.value = (_currentAnswerCount.value ?: 0) + 1
    }


    fun getPlateList() {
        val datasource = Datasource()
        platesList = datasource.loadPlates()
            .shuffled()
            .take(MAX_NO_OF_PLATES)
            .toMutableList()
    }

    /*
    * Re-initializes the game data to restart the game.
    */
    fun reinitializeData(isVersus: Boolean) {
        if(isVersus) {
            MAX_NO_OF_PLATES = VERSUS_COUNT
        } else {
            MAX_NO_OF_PLATES = TEST_COUNT
        }
        _currentScore.value = 100f
        _currentAnswerCount.value = 0
        getPlateList()
        getNextPlate()
    }

    fun checkAnswer(answer: Int) {
        if(currentPlate.value!!.answers[_answerOrder[answer - 1]].meaning != answerMeaning.CORRECT)
        {
            _currentScore.value = _currentScore.value!!.minus(SCORE_DECREASE)
        }
    }

    fun setOrder(order: List<Int>) {
        _answerOrder = order
    }

    fun downloadLeaderboard() {
        viewModelScope.launch {
            try {
                _scores.value = LeaderboardApi.retrofitService.getLeaderboard()
            } catch (error: java.lang.Exception) {
                _scores.value = listOf() // empty list in case of no internet connection
            }
        }
    }
}