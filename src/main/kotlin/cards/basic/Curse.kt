package cards.basic

import cards.Curse
import game.Player

data class Curse(override var owner: Player) : Curse {
    override val points: Int
        get() = -1
    override val cost: Int
        get() = 0
}