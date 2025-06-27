package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.domain.Car

class GameManager(
    val cars: List<Car>,
) {

    fun randomMoveCars(): GameManager {
        val movedCars = cars.map { car ->
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber < 4) car
            else car.move()
        }
        return GameManager(movedCars)
    }

    fun decideWinners() = cars.maxByOrNull { it.position }
        ?.let { maxCar -> cars.filter { it.position == maxCar.position } }
        ?: emptyList()
}
