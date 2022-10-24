package de.moritzluedtke.daiqserver.adapter.rest.api

import de.moritzluedtke.daiqserver.model.Question
import de.moritzluedtke.daiqserver.service.QuestionService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/question")
@CrossOrigin(origins = ["http://localhost:4200"])
class ApiQuestionRestController(private val questionService: QuestionService) {

    @GetMapping
    fun getCurrentQuestion(): Question {
        return questionService.getCurrentQuestion()
    }
}
