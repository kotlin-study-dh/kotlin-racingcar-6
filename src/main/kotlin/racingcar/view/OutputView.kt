package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

object OutputView {

    fun printResultTitle() {
        println("-- 실행 결과 --")
    }

    fun printResults(cars: Cars) {
        cars.cars.forEach { car ->
            println("${car.name} : " + "-".repeat(car.position))
        }

        println()
    }

    fun printWinners(winners: List<Car>) {
        print("최종 우승자 : ")
        println(winners.joinToString(separator = ", ") { it.name })
    }
}
