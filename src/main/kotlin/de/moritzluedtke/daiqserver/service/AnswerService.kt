package de.moritzluedtke.daiqserver.service

import com.google.gson.Gson
import de.moritzluedtke.daiqserver.adapter.websocket.AnswerWebSocketHandler
import de.moritzluedtke.daiqserver.model.UserAnswer
import org.springframework.stereotype.Service
import org.springframework.web.socket.TextMessage

@Service
class AnswerService(
    private val answerWebSocketHandler: AnswerWebSocketHandler
) {
    private val gson = Gson()
    var answers = mutableMapOf<String, String>()

    fun saveUserAnswer(userAnswer: UserAnswer) {
        answers[userAnswer.username] = userAnswer.chosenAnswer
    }

    fun publishUserAnswers() {
        answerWebSocketHandler.publishAllAnswers(
            TextMessage(
                gson.toJson(
                    answers
                )
            )
        )
    }
}
