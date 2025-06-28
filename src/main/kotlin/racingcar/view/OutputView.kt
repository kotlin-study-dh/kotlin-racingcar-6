package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Cars

class OutputView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printRacing(cars: Cars) {
        cars.cars.forEach { car ->
            val rail = "-".repeat(car.distance.value)
            println("${car.name} : $rail")
        }
        println()
    }

    fun printWinners(cars: Set<Car>) {
        print("최종 우승자 : ")
        println(cars.joinToString(", ") { car -> car.name })
    }
}