package racingcar.domain.participant

class Participants(names :List<String>) {

    val participants = names.map { Name(it) }
}
