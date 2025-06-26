package racingcar.domain

class Participants(names :List<String>) {

    val participants = names.map { Name(it) }
}
