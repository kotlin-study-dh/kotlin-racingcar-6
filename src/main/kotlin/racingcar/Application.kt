package racingcar

import racingcar.domain.Car
import racingcar.view.printExecutionResult
import racingcar.view.printExecutionResultPrompt
import racingcar.view.printWinners
import racingcar.view.readCarsName
import racingcar.view.readTryCount

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
