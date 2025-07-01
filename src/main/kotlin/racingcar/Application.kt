package racingcar

import racingcar.view.Input
import racingcar.view.Output

fun main() {
    val gameController = GameController(Input(), Output())
    gameController.run()
}
