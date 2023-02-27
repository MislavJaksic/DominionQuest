package cards.basic

import Player
import cards.VictoryCard

class Dutchy(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 3
    override val cost: Int
        get() = 5
}