package cards

import game.Player

interface Card {
    var owner: Player
    val cost: Int
}