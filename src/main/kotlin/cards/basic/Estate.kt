package cards.basic

import cards.VictoryCard
import game.Player

class Estate(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 1
    override val cost: Int
        get() = 2
}