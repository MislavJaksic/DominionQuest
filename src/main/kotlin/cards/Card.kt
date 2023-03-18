package cards

import Player

interface Card {
    var owner: Player
    val cost: Int
}