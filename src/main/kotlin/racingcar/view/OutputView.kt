package racingcar.view

import racingcar.domain.Car

fun printExecutionResultPrompt() = println("\n실행 결과")

fun printExecutionResult(cars: List<Car>) {
    cars.forEach {
        println(it.name + " : " + "-".repeat(it.position))
    }
    println()
}

fun printWinners(winners: List<Car>) {
    val winnerNames = winners.joinToString(", ") { it.name }
    println("최종 우승자 : $winnerNames")
}
