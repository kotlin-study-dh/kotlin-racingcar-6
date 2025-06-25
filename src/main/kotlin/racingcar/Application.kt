package racingcar

import racingcar.domain.Cars
import racingcar.domain.TrialCount
import racingcar.view.InputView

fun main() {
    val cars = Cars.withNames(InputView.readCarNames())
    val trialCount = TrialCount(InputView.readTrialCount())
}
