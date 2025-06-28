package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MovementRuleTest {

    @Test
    fun `should return true when machine returns threshold or higher`() {
        val rule = MovementRule(MachineReturnsThreshold())
        assertThat(rule.shouldMove()).isTrue
    }
    @Test
    fun `should return false when machine returns number below threshold`() {
        val rule = MovementRule(MachineReturnsBelowThreshold())
        assertThat(rule.shouldMove()).isFalse
    }

    private class MachineReturnsThreshold : NumberGenerator {
        override fun generate(numberMin: Int, numberMax: Int): Int {
            return MovementRule.THRESHOLD
        }
    }

    private class MachineReturnsBelowThreshold : NumberGenerator {
        override fun generate(numberMin: Int, numberMax: Int): Int {
            return MovementRule.THRESHOLD - 1
        }
    }
}