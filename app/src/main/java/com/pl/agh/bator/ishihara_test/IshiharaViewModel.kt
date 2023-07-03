package com.pl.agh.bator.ishihara_test

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pl.agh.bator.ishihara_test.data.Datasource
import com.pl.agh.bator.ishihara_test.data.IshiharaPlate
import com.pl.agh.bator.ishihara_test.data.answerMeaning
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
    val COUNTODWN_TIME = 30.0f

    private val _scores = MutableLiveData<List<LeaderboardScore>>()
    val scores : LiveData<List<LeaderboardScore>> = _scores

    private val _displayedName = MutableLiveData<String>()
    val displayedName : LiveData<String> = _displayedName

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

    private val _currentTime = MutableLiveData<Float>(30f)
    val currentTime: LiveData<Float>
        get() = _currentTime

    private var _answerOrder: List<Int> = listOf()

    var onTimerEnd = {}

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

    fun startCountdown()
    {
        object : CountDownTimer((COUNTODWN_TIME * 1000).toLong(), 100) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / 100).toFloat() / 10
            }
            override fun onFinish() {
                onTimerEnd()
            }
        }.start()

    }

    fun timeSubtraction()
    {
        _currentScore.value = _currentScore.value!!.minus(COUNTODWN_TIME - _currentTime.value!!)
        // subtracting unfinished plates
        _currentScore.value = _currentScore.value!!.minus((MAX_NO_OF_PLATES - currentAnswerCount.value!!) * SCORE_DECREASE)
        onTimerEnd = {}
    }

    fun setName(name: String)
    {
        _displayedName.value = name
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