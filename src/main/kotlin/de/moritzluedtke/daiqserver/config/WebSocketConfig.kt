package de.moritzluedtke.daiqserver.config

import de.moritzluedtke.daiqserver.adapter.websocket.AnswerWebSocketHandler
import de.moritzluedtke.daiqserver.adapter.websocket.RevealAnswerWebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig(
    private val revealAnswerHandler: RevealAnswerWebSocketHandler,
    private val answerWebSocketHandler: AnswerWebSocketHandler
) : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(revealAnswerHandler, "/reveal-answers").setAllowedOrigins("*")
        registry.addHandler(answerWebSocketHandler, "/answers").setAllowedOrigins("*")
    }
}
