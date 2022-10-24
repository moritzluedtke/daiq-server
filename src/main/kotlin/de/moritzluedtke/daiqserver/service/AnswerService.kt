package de.moritzluedtke.daiqserver.service

import de.moritzluedtke.daiqserver.model.ChosenAnswer
import org.springframework.stereotype.Service

@Service
class AnswerService {
    var answers = mutableMapOf<String, String>()

    fun saveChosenAnswer(chosenAnswer: ChosenAnswer) {
        answers[chosenAnswer.username] = chosenAnswer.answer
    }
}
