package racingcar.domain.rule

import org.junit.jupiter.api.Test

class ForwardGamblerTest {

    @Test
    fun `gamble should return boolean win case`() {
        // given
        val gambler = ForwardGambler()
        val randomNumberGenerator = RandomNumberGenerator()

        // when
        val gamble = gambler.gamble {
            randomNumberGenerator.generateInRange(4, 9)
        }

        // then
        assert(gamble)
    }

    @Test
    fun `gamble should return boolean lose case`() {
        // given
        val gambler = ForwardGambler()
        val randomNumberGenerator = RandomNumberGenerator()

        // when
        val gamble = gambler.gamble {
            randomNumberGenerator.generateInRange(1, 3)
        }

        // then
        assert(!gamble)
    }
}