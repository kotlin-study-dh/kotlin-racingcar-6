package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
}
