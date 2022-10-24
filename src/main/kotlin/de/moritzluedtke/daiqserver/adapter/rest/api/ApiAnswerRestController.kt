package de.moritzluedtke.daiqserver.adapter.rest.api

import de.moritzluedtke.daiqserver.model.ChosenAnswer
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/answer")
@CrossOrigin(origins = ["http://localhost:4200"])
class ApiAnswerRestController() {

    @PostMapping
    fun saveChosenAnswer(@RequestBody chosenAnswer: ChosenAnswer) {
        println("Got ${chosenAnswer.answer} from ${chosenAnswer.username}")
    }
}
