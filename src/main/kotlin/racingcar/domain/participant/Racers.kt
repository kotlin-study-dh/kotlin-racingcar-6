package racingcar.domain.participant

data class Racers(val racers: List<Racer>) {

    fun forward(track: Int): Racers {
        return Racers(racers.updateAt(track) { it.forward() })
    }

    private inline fun <T> List<T>.updateAt(index: Int, transform: (T) -> T): List<T> {
        return mapIndexed { i, item -> if (i == index) transform(item) else item }
    }

    val size get() = racers.size

    val status
        get() = racers.map { it.status }
}
