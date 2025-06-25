package racingcar

import racingcar.common.RandomPowerStrategy
import racingcar.domain.Cars
import racingcar.domain.TrialCount
import racingcar.view.InputView
import racingcar.view.OutputView

fun <T> retry(action: () -> T): T {
    while (true) {
        try {
            return action.invoke()
        } catch (e: IllegalArgumentException) {
            OutputView.printException(e)
        }
    }
}

fun main() {
    val cars = retry { Cars.withNames(InputView.readCarNames()) }
    val trialCount = retry { TrialCount(InputView.readTrialCount()) }

    OutputView.printResultTitle()
    repeat(trialCount.number) {
        cars.move(RandomPowerStrategy)
        OutputView.printResults(cars)
    }

    OutputView.printWinners(cars.winners())
}
