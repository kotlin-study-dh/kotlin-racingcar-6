package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = Console.readLine() ?: throw IllegalArgumentException("Car names are required.")
        return carNames.split(DEFAULT_DELIMITER).map { it.trim() }
    }

    fun readAttemptCount(): Int {
        println("시도할 회수는 몇회인가요?")
        val attemptCount = Console.readLine() ?: throw IllegalArgumentException("Attempt count is required.")
        return attemptCount.toIntOrNull() ?: throw IllegalArgumentException("Attempt count must be a a number.")
    }

    companion object {
        private const val DEFAULT_DELIMITER = ","
    }
}
