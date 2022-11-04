package de.moritzluedtke.daiqserver.service

import de.moritzluedtke.daiqserver.model.Player
import org.springframework.stereotype.Service

@Service
class PlayerService {
    var players = mutableListOf<Player>()
}
