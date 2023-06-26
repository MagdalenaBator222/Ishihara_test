package com.pl.agh.bator.ishihara_test.data

enum class answerMeaning {
    CORRECT,
    RED_GREEN,
    PROTANOPIA,
    DEUTERANOPIA,
    OTHER
}

data class IshiharaAnswer
    (
    val answer: String,
    val meaning: answerMeaning
)