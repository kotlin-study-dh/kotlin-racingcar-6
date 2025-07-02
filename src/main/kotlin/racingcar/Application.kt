package racingcar

import racingcar.controller.RacingController
import racingcar.generator.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingController = RacingController(
        InputView(),
        OutputView(),
        RandomNumberGenerator()
    )
    racingController.start()
}
