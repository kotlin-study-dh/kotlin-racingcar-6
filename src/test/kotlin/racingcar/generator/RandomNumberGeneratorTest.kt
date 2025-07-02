package racingcar.generator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomNumberGeneratorTest {
    @Test
    fun `generate returns a number between 0 and 9`() {
        // given
        val numberGenerator = RandomNumberGenerator()

        // when
        val generatedNumber = numberGenerator.generate()

        // then
        assertThat(generatedNumber).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9)
    }
}
