package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.car.Car

class GameTest {

    @Test
    fun `should return the winners`() {
        // given
        val game = Game(listOf("hi", "bye", "hey"))
        game.playRound()

        // when
        val winners = game.getWinners()

        // then
        assertThat(winners).hasSizeGreaterThanOrEqualTo(1)
    }

    @Test
    fun `returns a defensive copy to prevent external mutation`() {
        // given
        val game = Game(listOf("hi", "bye", "hey"))
        val cars = game.cars.toMutableList()

        // when
        cars.add(Car.from("new"))

        // then
        assertThat(game.cars).hasSize(3)
    }
}