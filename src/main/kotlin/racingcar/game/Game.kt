package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.car.Car

class Game(names: List<String>) {
    private val _cars: List<Car> = names.map { Car.from(it) }

    init {
        require(_cars.size >= 2) { "Game must have at least two car" }
    }

    val cars: List<Car>
        get() = _cars.toList()

    fun playRound() {
        _cars.filter { Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD }
            .forEach { it.forward() }
    }

    fun getWinners(): List<Car> {
        val maxPosition = _cars.maxOf { it.currentPosition() }
        return _cars.filter { it.currentPosition() == maxPosition }
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }

}