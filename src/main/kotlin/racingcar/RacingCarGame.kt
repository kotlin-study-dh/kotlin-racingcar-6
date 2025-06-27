package racingcar

class RacingCarGame {
    val inputView = InputView()
    val outputView = OutputView()

    fun start() {
        val cars = Cars.of(inputView.readNames())
        val ridingCount = RidingCount(inputView.readRidingCount())
        val movementRule = MovementRule(RandomNumberGenerator())

        outputView.printResultTitle()
        for (i in 1..ridingCount.count) {
            cars.move(movementRule)
            outputView.printRacing(cars)
        }
        outputView.printWinners(cars.findFarestCars())
    }
}
