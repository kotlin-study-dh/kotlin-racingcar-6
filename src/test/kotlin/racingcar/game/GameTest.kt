package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar.car.Car
import racingcar.car.Position
import java.util.stream.Stream

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

    @ParameterizedTest
    @MethodSource("insufficientNames")
    fun `should have at least two cars`(names: List<String>) {
        // when & then
        assertThrows<IllegalArgumentException> { Game(names) }
    }

    companion object {
        @JvmStatic
        private fun insufficientNames(): Stream<Arguments> = Stream.of(
            Arguments.of(emptyList<String>()),
            Arguments.of(listOf("only"))
        )
    }

    @Test
    fun `cannot change cars outside the game`() {
        // Given
        val game = Game(listOf("hi", "bye", "hey"))
        val copy = game.cars

        // When
        copy.forEach { it.forward() }

        // Then
        assertThat(game.cars).allMatch { it.position == Position(0) }
    }
}