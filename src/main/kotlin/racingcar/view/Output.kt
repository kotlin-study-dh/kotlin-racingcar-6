package racingcar.view

import racingcar.car.Car
import racingcar.game.Game

class Output {
    fun printCarNamesInputMessage() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRoundInputMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printRoundResultTitle() {
        println(System.lineSeparator() + "실행 결과")
    }

    fun printRoundResult(game: Game) {
        game.cars.forEach { car ->
            println("${car.name.value} : ${"-".repeat(car.currentPosition())}")
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name.value }
        println("최종 우승자 : $winnerNames")
    }

}