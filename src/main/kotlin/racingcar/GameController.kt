package racingcar

import racingcar.game.Game
import racingcar.view.Input
import racingcar.view.Output

class GameController(val input: Input, val output: Output) {

    fun run() {
        val game = initializeGame()
        val round = readRound()

        repeat(round) {
            game.playRound()
            showRoundResult(game)
        }

        showWinners(game)
    }

    private fun initializeGame(): Game {
        output.printCarNamesInputMessage()
        val carNames = input.readCarNames()
        val game = Game(carNames)
        return game
    }

    private fun readRound(): Int {
        output.printRoundInputMessage()
        val round = input.readRound()
        return round
    }

    private fun showRoundResult(game: Game) {
        output.printRoundResultTitle()
        output.printRoundResult(game)
    }

    private fun showWinners(game: Game) {
        val winners = game.getWinners()
        output.printWinners(winners)
    }

}