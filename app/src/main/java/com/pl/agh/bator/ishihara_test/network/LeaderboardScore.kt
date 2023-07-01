package com.pl.agh.bator.ishihara_test.network

data class LeaderboardScore(val id: Int, val name: String, val score: Float) {
    var scoreString : String = score.toString()
}