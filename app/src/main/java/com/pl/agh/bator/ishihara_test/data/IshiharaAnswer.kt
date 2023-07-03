package com.pl.agh.bator.ishihara_test.data

enum class answerMeaning(val number: Int) {
    CORRECT(0),
    RED_GREEN(1),
    PROTANOPIA(2),
    DEUTERANOPIA(3),
    OTHER(4)
}

data class IshiharaAnswer
    (
    val answer: String,
    val meaning: answerMeaning
)