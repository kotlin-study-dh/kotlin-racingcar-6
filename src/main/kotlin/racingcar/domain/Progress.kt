package racingcar.domain

data class Progress(val progress: Long = 0) {

    init {
        require(progress >= 0) {
            "progress must be greater than or equal to 0"
        }
    }

    fun increase(step: Long) : Progress {
        return Progress(progress + step)
    }
}