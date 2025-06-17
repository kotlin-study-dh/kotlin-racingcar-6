package racingcar

import org.junit.jupiter.api.Test
import racingcar.view.Input
import racingcar.view.Output

class GameControllerTest {

    @Test
    fun `run well`() {
        val input = Input()
        val output = Output()
        val gameController = GameController(input, output) // input output 을 전달해주도록 구현, game은 자동차들을 상태로 갖게될 것.

        gameController.run()
    }

}