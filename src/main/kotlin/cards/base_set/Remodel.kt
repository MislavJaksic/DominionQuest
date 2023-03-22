package cards.base_set

import cards.ActionCard
import game.Player

data class Remodel(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 4

    override fun execute() {
        val supply = owner.gameState.supply
        val controller = owner.gameState.controller

        val trashedCard = controller.askToPickCards(owner.hand, 1)[0]
        owner.trash(trashedCard)

        val cards = supply.getSoldCardsUpToCost(trashedCard.cost + 2)
        val gainedCard = controller.askToPickCards(cards, 1)[0]

        owner.gain(supply.sell(gainedCard))
    }
}