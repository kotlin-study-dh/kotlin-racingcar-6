package racingcar

import racingcar.game.Game
import racingcar.view.Input
import racingcar.view.Output

class GameController(val input: Input, val output: Output) {

    fun run() {
        // todo: input
        val game = Game(listOf("pobi", "woni", "jun"))

        // todo: input
        val round = 5

        repeat(round) {
            game.playRound()
            // todo: output
            game.cars.forEach { car -> }
        }

        val winners = game.getWinners()
        // todo: output
    }

}