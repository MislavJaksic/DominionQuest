package cards.basic

import Player
import cards.VictoryCard

data class Duchy(override var owner: Player) : VictoryCard {
    override val points: Int
        get() = 3
    override val cost: Int
        get() = 5
}