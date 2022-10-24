package de.moritzluedtke.daiqserver.adapter.rest.api

import de.moritzluedtke.daiqserver.model.UserAnswer
import de.moritzluedtke.daiqserver.service.AnswerService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = ["http://localhost:4200"])
class ApiAnswerRestController(private val answerService: AnswerService) {

    @PostMapping
    fun saveChosenAnswer(@RequestBody userAnswer: UserAnswer) {
        answerService.saveUserAnswer(userAnswer)
    }
}
