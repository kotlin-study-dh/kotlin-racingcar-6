package racingcar.controller

import racingcar.domain.AttemptCount
import racingcar.domain.Cars
import racingcar.generator.NumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val numberGenerator: NumberGenerator,
) {
    fun start() {
        val cars = getCars()
        val attemptCount = getAttemptCount()

        outputView.printResult()
        while (attemptCount.canAttempt()) {
            attemptCount.decrement()
            cars.moveAll(numberGenerator)
            outputView.printPositions(cars.cars)
        }
        outputView.printWinners(cars.getWinners())
    }

    private fun getCars(): Cars {
        val carNames = inputView.readCarNames()
        return Cars(carNames)
    }

    private fun getAttemptCount(): AttemptCount {
        val attemptCount = inputView.readAttemptCount()
        return AttemptCount(attemptCount)
    }
}
