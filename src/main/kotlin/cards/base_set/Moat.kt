package cards.base_set

import cards.ActionCard
import game.Player

data class Moat(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 2

    override fun execute() {
        owner.draw(2)
    }
}