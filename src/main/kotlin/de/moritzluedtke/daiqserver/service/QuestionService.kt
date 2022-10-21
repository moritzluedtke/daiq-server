package de.moritzluedtke.daiqserver.service

import de.moritzluedtke.daiqserver.model.Question
import org.springframework.stereotype.Service

@Service
class QuestionService {

    fun getCurrentQuestion(): Question {
        return Question(
            question = "Für welche Rolle ist Richard Dean Anderson noch bekannt, außer für Sgt. Jack O'Neill",
            mapOf(
                "A" to "MacGyver",
                "B" to "Darth Vader",
                "C" to "Spiderman",
                "D" to "Richard Castle"
            )
        )
    }
}
