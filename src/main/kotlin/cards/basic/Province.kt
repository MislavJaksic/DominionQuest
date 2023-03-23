package cards.basic

import cards.VictoryCard
import game.Player

data class Province(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 6
    override val cost: Int
        get() = 8
}