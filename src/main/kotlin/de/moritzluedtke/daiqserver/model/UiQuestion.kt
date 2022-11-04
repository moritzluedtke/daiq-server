package de.moritzluedtke.daiqserver.model

/**
 * A Question without the correct answer.
 */
class UiQuestion(
    val question: String,
    val answers: Map<String, String>
) {
    companion object {
        fun fromQuestion(question: Question?): UiQuestion {
            if (question != null) {
                return UiQuestion(
                    question = question.question,
                    answers = question.answers
                )
            }
            return UiQuestion("", emptyMap())
        }
    }
}
