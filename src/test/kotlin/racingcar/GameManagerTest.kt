package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.Car

class GameManagerTest {

    @Test
    fun `verify car doesn't move when number is below threshold`() {
        val gameManager = GameManager(
            listOf(Car("ky", 0))
        ).randomMoveCars(FixedNumberGenerator(3))
        val car = gameManager.cars.first()

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `verify car move when number is threshold or more`() {
        val gameManager = GameManager(
            listOf(Car("hj", 0))
        ).randomMoveCars(FixedNumberGenerator(4))
        val car = gameManager.cars.first()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `verify decide winners`() {
        val hj = Car("hj", 2)
        val ky = Car("ky", 2)
        val chung = Car("chung", 1)
        val gameManager = GameManager(listOf(hj, ky, chung))

        assertThat(gameManager.decideWinners()).isEqualTo(listOf(hj, ky))
    }
}

class FixedNumberGenerator(private val number: Int) : NumberGenerator {
    override fun generate(min: Int, max: Int): Int {
        return number
    }
}
