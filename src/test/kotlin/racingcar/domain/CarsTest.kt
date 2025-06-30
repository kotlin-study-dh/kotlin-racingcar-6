package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.powerstrategy.PowerStrategy

class CarsTest {

    @Test
    fun `create Cars object`() {
        val cars = Cars.withNames(listOf("Lee", "Kim", "Park"))
        assertThat(cars.cars.map { it.name })
            .containsExactly("Lee", "Kim", "Park")
    }

    @Test
    fun `there must be at least two cars`() {
        assertThrows<IllegalArgumentException> { Cars.withNames(listOf("Lee")) }
        assertThrows<IllegalArgumentException> { Cars.withNames(emptyList()) }
    }

    @Test
    fun `maximum 15 cars`() {
        val names = listOf(
            "a", "b", "c", "d", "e",
            "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o",
            "p"
        )

        assertThrows<IllegalArgumentException> { Cars.withNames(names) }
    }

    @Test
    fun `no duplication allowed for car names`() {
        assertThrows<IllegalArgumentException> { Cars.withNames(listOf("a", "a")) }
    }

    @Test
    fun `all Cars move forward when power == 4`() {
        // given
        val cars = Cars.withNames(listOf("Lee", "Kim"))

        // when
        cars.move(object : PowerStrategy {
            override fun generatePower() = 4
        })

        // then
        assertThat(cars.cars).allMatch { it.position == 1 }
    }

    @Test
    fun `all Cars don't move when power == 3`() {
        // given
        val cars = Cars.withNames(listOf("Lee", "Kim"))

        // when
        cars.move(object : PowerStrategy {
            override fun generatePower() = 3
        })

        // then
        assertThat(cars.cars.map { it.position })
            .containsExactly(0, 0)
    }

    @Test
    fun `find winners`() {
        // given
        val cars = Cars.withNames(listOf("Lee", "Kim", "Park"))

        // when
        cars.cars[1].moveForward(4)
        cars.cars[2].moveForward(4)

        // then
        assertThat(cars.winners().map { it.name })
            .containsExactly("Kim", "Park")
            .doesNotContain("Lee")
    }
}
