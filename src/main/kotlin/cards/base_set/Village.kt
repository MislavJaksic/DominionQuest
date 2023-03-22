package cards.base_set

import cards.ActionCard
import game.Player

data class Village(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 3

    override fun execute() {
        owner.draw(1)
        owner.addActions(2)
    }
}