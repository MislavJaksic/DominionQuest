package cards.base_set

import cards.ActionCard
import game.Player

data class Workshop(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 3

    override fun execute() {
        val supply = owner.gameState.supply
        val controller = owner.gameState.controller

        val cards = supply.getSoldCardsUpToCost(4)
        val gainedCard = controller.askToPickCards(cards, 1)[0]
        owner.gain(supply.sell(gainedCard))
    }
}