package cards.basic

import cards.VictoryCard
import game.Player

data class Duchy(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 3
    override val cost: Int
        get() = 5
}