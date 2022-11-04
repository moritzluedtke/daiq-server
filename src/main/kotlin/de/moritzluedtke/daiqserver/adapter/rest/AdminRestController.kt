package de.moritzluedtke.daiqserver.adapter.rest

import com.google.gson.Gson
import de.moritzluedtke.daiqserver.adapter.websocket.RevealAnswerWebSocketHandler
import de.moritzluedtke.daiqserver.model.Question
import de.moritzluedtke.daiqserver.model.RevealAnswerDto
import de.moritzluedtke.daiqserver.service.QuestionService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.socket.TextMessage

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = ["http://localhost:4200"])
class AdminRestController(
    private val questionService: QuestionService,
    private val revealAnswerWebSocketHandler: RevealAnswerWebSocketHandler
) {

    private val gson = Gson()

    @GetMapping("/question")
    fun getCurrentQuestion(): Question? {
        return questionService.getCurrentQuestion()
    }

    @PostMapping("/question")
    fun saveQuestion(@RequestBody question: Question) {
        questionService.saveQuestion(question)
    }

    @PostMapping("/reveal-correct-answer")
    fun revealCorrectAnswer() {
        val currentQuestion = questionService.getCurrentQuestion()
        revealAnswerWebSocketHandler.publishMessage(
            TextMessage(
                gson.toJson(
                    RevealAnswerDto(
                        revealAnswer = true,
                        correctAnswer = currentQuestion?.correctAnswer ?: ""
                    )
                )
            )
        )
    }
}
