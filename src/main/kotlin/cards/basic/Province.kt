package cards.basic

import Player
import cards.VictoryCard

class Province(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 6
    override val cost: Int
        get() = 8
}