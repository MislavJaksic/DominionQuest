package cards

import Player

interface Card {
    val owner: Player
    val cost: Int
}