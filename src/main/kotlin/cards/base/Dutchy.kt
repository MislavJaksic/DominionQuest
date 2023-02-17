package cards.base

import Player
import cards.VictoryCard

class Dutchy(override val player: Player) : VictoryCard {
    override val points: Int
        get() = 3
    override val cost: Int
        get() = 5
}