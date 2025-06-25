package racingcar

import racingcar.common.RandomPowerStrategy
import racingcar.domain.Cars
import racingcar.domain.TrialCount
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val cars = Cars.withNames(InputView.readCarNames())
    val trialCount = TrialCount(InputView.readTrialCount())

    OutputView.printResultTitle()
    repeat(trialCount.number) {
        cars.move(RandomPowerStrategy)
        OutputView.printResults(cars)
    }
}
