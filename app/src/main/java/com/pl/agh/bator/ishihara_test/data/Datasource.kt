package com.pl.agh.bator.ishihara_test.data

import com.pl.agh.bator.ishihara_test.R

class Datasource {

    fun loadPlates(): MutableList<IshiharaPlate> {
        return mutableListOf<IshiharaPlate>(
            IshiharaPlate(1, R.drawable.plate_1, listOf<IshiharaAnswer>(
                IshiharaAnswer("12", answerMeaning.CORRECT),
                IshiharaAnswer("1", answerMeaning.OTHER),
                IshiharaAnswer("13", answerMeaning.OTHER)
            )),
            IshiharaPlate(2, R.drawable.plate_2, listOf<IshiharaAnswer>(
                IshiharaAnswer("8", answerMeaning.CORRECT),
                IshiharaAnswer("3", answerMeaning.RED_GREEN),
                IshiharaAnswer("6", answerMeaning.OTHER)
            )),
            IshiharaPlate(3, R.drawable.plate_3, listOf<IshiharaAnswer>(
                IshiharaAnswer("6", answerMeaning.CORRECT),
                IshiharaAnswer("5", answerMeaning.RED_GREEN),
                IshiharaAnswer("3", answerMeaning.OTHER)
            )),
            IshiharaPlate(4, R.drawable.plate_4, listOf<IshiharaAnswer>(
                IshiharaAnswer("29", answerMeaning.CORRECT),
                IshiharaAnswer("70", answerMeaning.RED_GREEN),
                IshiharaAnswer("44", answerMeaning.OTHER)
            )),
            IshiharaPlate(5, R.drawable.plate_5, listOf<IshiharaAnswer>(
                IshiharaAnswer("57", answerMeaning.CORRECT),
                IshiharaAnswer("35", answerMeaning.RED_GREEN),
                IshiharaAnswer("55", answerMeaning.OTHER)
            )),
            IshiharaPlate(6, R.drawable.plate_6, listOf<IshiharaAnswer>(
                IshiharaAnswer("5", answerMeaning.CORRECT),
                IshiharaAnswer("2", answerMeaning.RED_GREEN),
                IshiharaAnswer("6", answerMeaning.OTHER)
            )),
            IshiharaPlate(7, R.drawable.plate_7, listOf<IshiharaAnswer>(
                IshiharaAnswer("3", answerMeaning.CORRECT),
                IshiharaAnswer("5", answerMeaning.RED_GREEN),
                IshiharaAnswer("8", answerMeaning.OTHER)
            )),
            IshiharaPlate(8, R.drawable.plate_8, listOf<IshiharaAnswer>(
                IshiharaAnswer("15", answerMeaning.CORRECT),
                IshiharaAnswer("17", answerMeaning.RED_GREEN),
                IshiharaAnswer("16", answerMeaning.OTHER)
            )),
            IshiharaPlate(9, R.drawable.plate_9, listOf<IshiharaAnswer>(
                IshiharaAnswer("74", answerMeaning.CORRECT),
                IshiharaAnswer("21", answerMeaning.RED_GREEN),
                IshiharaAnswer("45", answerMeaning.OTHER)
            )),
            IshiharaPlate(10, R.drawable.plate_10, listOf<IshiharaAnswer>(
                IshiharaAnswer("2", answerMeaning.CORRECT),
                IshiharaAnswer("3", answerMeaning.RED_GREEN),
                IshiharaAnswer("6", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(11, R.drawable.plate_11, listOf<IshiharaAnswer>(
                IshiharaAnswer("6", answerMeaning.CORRECT),
                IshiharaAnswer("5", answerMeaning.RED_GREEN),
                IshiharaAnswer("1", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(12, R.drawable.plate_12, listOf<IshiharaAnswer>(
                IshiharaAnswer("97", answerMeaning.CORRECT),
                IshiharaAnswer("52", answerMeaning.RED_GREEN),
                IshiharaAnswer("11", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(13, R.drawable.plate_13, listOf<IshiharaAnswer>(
                IshiharaAnswer("45", answerMeaning.CORRECT),
                IshiharaAnswer("33", answerMeaning.RED_GREEN),
                IshiharaAnswer("76", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(14, R.drawable.plate_14, listOf<IshiharaAnswer>(
                IshiharaAnswer("5", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("6", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(15, R.drawable.plate_15, listOf<IshiharaAnswer>(
                IshiharaAnswer("7", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("1", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(16, R.drawable.plate_16, listOf<IshiharaAnswer>(
                IshiharaAnswer("16", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("8", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(17, R.drawable.plate_17, listOf<IshiharaAnswer>(
                IshiharaAnswer("96", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("16", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(18, R.drawable.plate_18, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("5", answerMeaning.RED_GREEN),
                IshiharaAnswer("6", answerMeaning.OTHER)
            )),
            IshiharaPlate(19, R.drawable.plate_19, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("2", answerMeaning.RED_GREEN),
                IshiharaAnswer("7", answerMeaning.OTHER)
            )),
            IshiharaPlate(20, R.drawable.plate_20, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("45", answerMeaning.RED_GREEN),
                IshiharaAnswer("46", answerMeaning.OTHER)
            )),
            IshiharaPlate(21, R.drawable.plate_21, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("73", answerMeaning.RED_GREEN),
                IshiharaAnswer("13", answerMeaning.OTHER)
            )),
            IshiharaPlate(22, R.drawable.plate_22, listOf<IshiharaAnswer>(
                IshiharaAnswer("26", answerMeaning.CORRECT),
                IshiharaAnswer("6", answerMeaning.PROTANOPIA),
                IshiharaAnswer("2", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(23, R.drawable.plate_23, listOf<IshiharaAnswer>(
                IshiharaAnswer("42", answerMeaning.CORRECT),
                IshiharaAnswer("2", answerMeaning.PROTANOPIA),
                IshiharaAnswer("4", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(24, R.drawable.plate_24, listOf<IshiharaAnswer>(
                IshiharaAnswer("35", answerMeaning.CORRECT),
                IshiharaAnswer("5", answerMeaning.PROTANOPIA),
                IshiharaAnswer("3", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(25, R.drawable.plate_25, listOf<IshiharaAnswer>(
                IshiharaAnswer("96", answerMeaning.CORRECT),
                IshiharaAnswer("6", answerMeaning.PROTANOPIA),
                IshiharaAnswer("9", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(26, R.drawable.plate_26, listOf<IshiharaAnswer>(
                IshiharaAnswer("purple and red spots", answerMeaning.CORRECT),
                IshiharaAnswer("purple line", answerMeaning.PROTANOPIA),
                IshiharaAnswer("red  line", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(27, R.drawable.plate_27, listOf<IshiharaAnswer>(
                IshiharaAnswer("purple and red spots", answerMeaning.CORRECT),
                IshiharaAnswer("purple line", answerMeaning.PROTANOPIA),
                IshiharaAnswer("red  line", answerMeaning.DEUTERANOPIA)
            )),
            IshiharaPlate(28, R.drawable.plate_28, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("line", answerMeaning.RED_GREEN),
                IshiharaAnswer("circle", answerMeaning.OTHER)
            )),
            IshiharaPlate(29, R.drawable.plate_29, listOf<IshiharaAnswer>(
                IshiharaAnswer("nothing", answerMeaning.CORRECT),
                IshiharaAnswer("line", answerMeaning.RED_GREEN),
                IshiharaAnswer("W letter", answerMeaning.OTHER)
            )),
            IshiharaPlate(30, R.drawable.plate_30, listOf<IshiharaAnswer>(
                IshiharaAnswer("blue-green line", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("red line", answerMeaning.OTHER)
            )),
            IshiharaPlate(31, R.drawable.plate_31, listOf<IshiharaAnswer>(
                IshiharaAnswer("blue-green line", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("yellow line", answerMeaning.OTHER)
            )),
            IshiharaPlate(32, R.drawable.plate_32, listOf<IshiharaAnswer>(
                IshiharaAnswer("orange line", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("green line", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(33, R.drawable.plate_33, listOf<IshiharaAnswer>(
                IshiharaAnswer("orange line", answerMeaning.CORRECT),
                IshiharaAnswer("nothing", answerMeaning.RED_GREEN),
                IshiharaAnswer("blue line", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(34, R.drawable.plate_34, listOf<IshiharaAnswer>(
                IshiharaAnswer("blue-green and yellow-green line", answerMeaning.CORRECT),
                IshiharaAnswer("red-green line", answerMeaning.RED_GREEN),
                IshiharaAnswer("violet line", answerMeaning.RED_GREEN)
            )),
            IshiharaPlate(35, R.drawable.plate_35, listOf<IshiharaAnswer>(
                IshiharaAnswer("blue-green and yellow-green line", answerMeaning.CORRECT),
                IshiharaAnswer("blue-green and violet line", answerMeaning.RED_GREEN),
                IshiharaAnswer("blue-green and blue line", answerMeaning.OTHER)
            )),
            IshiharaPlate(36, R.drawable.plate_36, listOf<IshiharaAnswer>(
                IshiharaAnswer("violet and orange line", answerMeaning.CORRECT),
                IshiharaAnswer("blue-green and violet line", answerMeaning.RED_GREEN),
                IshiharaAnswer("blue-green and orange line", answerMeaning.OTHER)
            )),
            IshiharaPlate(37, R.drawable.plate_37, listOf<IshiharaAnswer>(
                IshiharaAnswer("violet and orange line", answerMeaning.CORRECT),
                IshiharaAnswer("blue-green and violet line", answerMeaning.RED_GREEN),
                IshiharaAnswer("blue-green and orange line", answerMeaning.OTHER)
            )),
            IshiharaPlate(38, R.drawable.plate_38, listOf<IshiharaAnswer>(
                IshiharaAnswer("line", answerMeaning.CORRECT),
                IshiharaAnswer("sad face", answerMeaning.RED_GREEN),
                IshiharaAnswer("cat", answerMeaning.OTHER)
            ))
        )
    }
}
