package cards.base_set

import cards.ActionCard
import cards.TreasureCard
import game.Player

data class Mine(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 5

    override fun execute() {
        val supply = owner.gameState.supply
        val controller = owner.gameState.controller

        val trashedCard = controller.askToPickCards(owner.hand.filterIsInstance<TreasureCard>(), 1)[0]
        owner.trash(trashedCard)

        val cards = supply.getSoldCardsUpToCost(trashedCard.cost + 3).filterIsInstance<TreasureCard>()
        val gainedCard = controller.askToPickCards(cards, 1)[0]

        owner.gain(supply.sell(gainedCard))
    }
}