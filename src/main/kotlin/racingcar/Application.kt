package racingcar

import racingcar.domain.TrialCount
import racingcar.view.InputView

fun main() {
    val carNames = InputView.readCarNames()
    val trialCount = TrialCount(InputView.readTrialCount())
}
