package cards.base

import Player
import cards.VictoryCard

class Province(override val player: Player) : VictoryCard {
    override val points: Int
        get() = 6
    override val cost: Int
        get() = 8
}