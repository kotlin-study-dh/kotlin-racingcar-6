package racingcar.domain

class Progress(progress: Long) {

    init {
        require(progress >= 0) {
            "progress must be greater than or equal to 0"
        }
    }
}