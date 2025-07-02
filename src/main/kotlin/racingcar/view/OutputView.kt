package racingcar.view

import racingcar.domain.Car

class OutputView {
    fun printResult() {
        println(System.lineSeparator() + "실행 결과")
    }

    fun printPositions(cars: List<Car>) {
        cars.forEach { println("${it.name} : ${"-".repeat(it.position)}") }
        println()
    }

    fun printWinners(winners: List<Car>) {
        println("최종 우승자 : ${winners.joinToString(", ") { it.name }}")
    }
}
