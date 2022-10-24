package de.moritzluedtke.daiqserver.service

import de.moritzluedtke.daiqserver.model.UserAnswer
import org.springframework.stereotype.Service

@Service
class AnswerService {
    var answers = mutableMapOf<String, String>()

    fun saveUserAnswer(userAnswer: UserAnswer) {
        answers[userAnswer.username] = userAnswer.answer
    }
}
