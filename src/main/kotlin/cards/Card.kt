package cards

import Player

interface Card {
    val player: Player
    val cost: Int
}