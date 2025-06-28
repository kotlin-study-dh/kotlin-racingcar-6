package racingcar

import racingcar.domain.Cars
import racingcar.domain.RidingCount
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarGame {

    val inputView = InputView()
    val outputView = OutputView()

    fun start() {
        val cars = Cars.of(inputView.readNames())
        val ridingCount = RidingCount(inputView.readRidingCount())
        val movementRule = MovementRule(RandomNumberGenerator())

        outputView.printResultTitle()
        repeat(ridingCount.count) {
            cars.move(movementRule)
            outputView.printRacing(cars)
        }
        outputView.printWinners(cars.findFarthestCars())
    }
}
