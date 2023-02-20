package cards.base

import Player
import cards.VictoryCard

class Estate(override val owner: Player) : VictoryCard {
    override val points: Int
        get() = 1
    override val cost: Int
        get() = 2
}