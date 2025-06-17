package racingcar.view

import org.junit.jupiter.api.Test
import racingcar.game.Game

class OutputTest {

    @Test
    fun printRoundResult() {
        // given
        val game = Game(listOf("hi", "pobi", "rosie"))
        val output = Output()

        game.playRound()
        val winners = game.getWinners()

        // when & then
        output.printRoundResult(winners)
    }

    @Test
    fun printGameResult() {
        //given
        val game = Game(listOf("bye", "pobi", "rosie", "hello"))
        val output = Output()
        game.playRound()
        val winners = game.getWinners()

        // when & then
        output.printWinners(winners)
    }
}