package racingcar.game

import camp.nextstep.edu.missionutils.Randoms
import racingcar.car.Car

class Game(names: List<String>) {
    private var _cars: List<Car> = names.map { Car.from(it) }
    val cars: List<Car>
        get() = _cars.toList()

    init {
        require(_cars.size >= 2) { "Game must have at least two car" }
    }


    fun playRound() {
        _cars = _cars.map { car ->
            val canMove = Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD
            if (canMove) car.forward() else car
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = _cars.maxOf { it.currentPosition() }
        return _cars.filter { it.currentPosition() == maxPosition }
    }

    companion object {
        const val MOVE_THRESHOLD = 4
    }

}