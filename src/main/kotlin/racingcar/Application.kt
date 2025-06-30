package racingcar

import racingcar.domain.Car
import racingcar.view.*

fun main() {
    val cars: List<Car> = readCarsName().map { Car(it) }
    val tryCount = readTryCount()
    var gameManager = GameManager(cars)

    printExecutionResultPrompt()
    repeat(tryCount) {
        gameManager = gameManager.randomMoveCars(RandomGenerator)
        printExecutionResult(gameManager.cars)
    }
    printWinners(gameManager.decideWinners())
}
