package cards.base_set

import cards.ActionCard
import game.Player

class Market(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 5

    override fun execute() {
        owner.draw(1)
        owner.addActions(1)
        owner.addBuys(1)
        owner.addCoins(1)
    }
}