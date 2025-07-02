package racingcar

import racingcar.domain.RacingGame
import racingcar.view.Input
import racingcar.view.Output

fun main() {
    val participants = Input.enterParticipants()
    val round = Input.enterRound()
    val game = RacingGame(participants)
    val playLogs = game.play(round)
    Output.printRaceLog(playLogs)
    Output.printWinner(game.winners)
}
