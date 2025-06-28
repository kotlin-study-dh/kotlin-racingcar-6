package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView() {

    fun readNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val names = readLine()
        if (names.isNullOrBlank()) {
            throw IllegalArgumentException("Name are required")
        }
        return names.split(",").map { it -> it.trim() }
    }

    fun readRidingCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return try {
            read().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Trying count should be number")
        }
    }

    fun read(): String = Console.readLine()
}