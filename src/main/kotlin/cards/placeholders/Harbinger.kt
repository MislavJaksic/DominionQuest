package cards.placeholders

import cards.ActionCard
import game.Player

data class Harbinger(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = -1

    override fun execute() {
    }
}