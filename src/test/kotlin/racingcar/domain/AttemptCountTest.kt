package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class AttemptCountTest {
    @ParameterizedTest(name = "invalid attempt count: {0}")
    @ValueSource(ints = [0, 11])
    fun `fails to create AttemptCount when count is less than MIN_ATTEMPT_COUNT or greater than MAX_ATTEMPT_COUNT`(
        invalidCount: Int,
    ) {
        // when & then
        assertThatThrownBy {
            AttemptCount(invalidCount)
        }.isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Attempt count must be between 1 and 10.")
    }

    @ParameterizedTest(name = "valid attempt count: {0}")
    @ValueSource(ints = [1, 10])
    fun `succeeds in creating AttemptCount when count is between MIN_ATTEMPT_COUNT and MAX_ATTEMPT_COUNT`(validCount: Int) {
        // when
        val attemptCount = AttemptCount(validCount)

        // then
        assertThat(attemptCount.count).isEqualTo(validCount)
    }

    @Test
    fun `decrement the count by one`() {
        // given
        val attemptCount = AttemptCount(5)

        // when
        attemptCount.decrement()

        // then
        assertThat(attemptCount.count).isEqualTo(4)
    }

    @Test
    fun `fails to decrement the count below zero`() {
        // given
        val attemptCount = AttemptCount(1)
        attemptCount.decrement() // Decrement to zero

        // when & then
        assertThatThrownBy { attemptCount.decrement() }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Attempt count cannot decrement below zero.")
    }

    @Test
    fun `returns true when count is greater than zero`() {
        // given
        val attemptCount = AttemptCount(1)

        // when
        val canAttempt = attemptCount.canAttempt()

        // then
        assertThat(canAttempt).isTrue()
    }

    @Test
    fun `returns false when count is zero`() {
        // given
        val attemptCount = AttemptCount(1)
        attemptCount.decrement() // Decrement to zero

        // when
        val canAttempt = attemptCount.canAttempt()

        // then
        assertThat(canAttempt).isFalse()
    }
}
