package de.moritzluedtke.daiqserver.service

import de.moritzluedtke.daiqserver.model.Question
import org.springframework.stereotype.Service

@Service
class QuestionService {

    var question: Question? = null

    fun getCurrentQuestion(): Question? {
        return question
    }

    fun saveQuestion(question: Question) {
        this.question = question
    }
}
