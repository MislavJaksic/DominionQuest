package cards.vanilla

import Player
import cards.ActionCard

data class Cellar(override var owner: Player):ActionCard {
    override fun execute() {
        owner.addActions(1)
        val cardsToDiscard = owner.gameState.controller.askToPickCards(owner.hand, 0)
        for (card in cardsToDiscard) {
            owner.discard(card)
        }
        owner.draw(cardsToDiscard.size)
    }

    override val cost: Int
        get() = 2
}
