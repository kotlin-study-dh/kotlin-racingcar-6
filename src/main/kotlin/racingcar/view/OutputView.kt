package racingcar.view

import racingcar.domain.Car

fun printExecutionResultPrompt() = println("실행 결과")

fun printExecutionResult(cars: List<Car>) {
    cars.forEach {
        println(it.name + " : " + "-".repeat(it.position))
    }
    println()
}
