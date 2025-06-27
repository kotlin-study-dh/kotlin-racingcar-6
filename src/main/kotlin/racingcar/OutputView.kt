package racingcar

class OutputView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printRacing(cars: Cars) {
        cars.cars.forEach { car ->
            val rail = "-".repeat(car.distance)
            println("${car.name} : $rail")
        }
        println()
    }

    fun printWinners(cars: List<Car>) {
        print("최종 우승자 : ")
        println(cars.joinToString(", ") { car -> car.name })
    }
}