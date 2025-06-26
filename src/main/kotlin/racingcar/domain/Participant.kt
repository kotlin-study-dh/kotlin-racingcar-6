package racingcar.domain

class Participant (name: String, progress: Long = 0) {

    val name = Name(name)

    val progress = Progress(progress)
}