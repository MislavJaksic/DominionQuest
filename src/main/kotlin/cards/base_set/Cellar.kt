package cards.base_set

import cards.ActionCard
import game.Player

data class Cellar(override var owner: Player) : ActionCard {
    override fun execute() {
        owner.addActions(1)
        val cardsToDiscard = owner.gameState.controller.askToPickCards(owner.hand, -1)
        for (card in cardsToDiscard) {
            owner.discard(card)
        }
        owner.draw(cardsToDiscard.size)
    }

    override val cost: Int
        get() = 2
}