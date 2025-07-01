package racingcar.view

import camp.nextstep.edu.missionutils.Console
import racingcar.game.GameCount

class Input {
    fun readCarNames(): List<String> = Console.readLine().split(",")

    fun readRound(): GameCount = GameCount(Console.readLine().toInt())

}