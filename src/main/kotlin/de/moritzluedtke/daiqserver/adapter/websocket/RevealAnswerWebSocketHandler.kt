package de.moritzluedtke.daiqserver.adapter.websocket

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.util.Collections

@Component
class RevealAnswerWebSocketHandler : TextWebSocketHandler() {
    var webSocketSessions: MutableList<WebSocketSession> = Collections.synchronizedList(ArrayList())

    override fun afterConnectionEstablished(session: WebSocketSession) {
        super.afterConnectionEstablished(session)
        webSocketSessions.add(session)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        super.afterConnectionClosed(session, status)
        webSocketSessions.remove(session)
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        super.handleMessage(session, message)
        for (webSocketSession in webSocketSessions) {
            webSocketSession.sendMessage(message)
        }
    }

    fun publishMessage(message: WebSocketMessage<*>) {
        for (webSocketSession in webSocketSessions) {
            webSocketSession.sendMessage(message)
        }
    }
}
