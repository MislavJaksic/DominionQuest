package cards.base_set

import cards.ActionCard
import game.Player

data class Smithy(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 4

    override fun execute() {
        owner.draw(3)
    }
}