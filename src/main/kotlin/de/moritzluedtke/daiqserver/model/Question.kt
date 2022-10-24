package de.moritzluedtke.daiqserver.model

class Question(
    val question: String,
    val answers: Map<String, String>,
    val correctAnswer: String
)
