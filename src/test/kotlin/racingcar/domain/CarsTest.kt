package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.common.PowerStrategy

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
        assertThat(cars.cars.map { it.position })
            .containsExactly(1, 1)
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
        val cars = Cars.withNames(listOf("Lee", "Kim"))

        // when
        cars.move(object : PowerStrategy {
            override fun generatePower() = 4
        })

        // then
        assertThat(cars.winners().map { it.name })
            .containsExactly("Lee", "Kim")
    }
}
