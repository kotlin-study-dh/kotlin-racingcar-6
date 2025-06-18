package racingcar.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun readCarNames(): List<String> = Console.readLine().split(",")

    fun readRound(): Int = Console.readLine().toInt()

}