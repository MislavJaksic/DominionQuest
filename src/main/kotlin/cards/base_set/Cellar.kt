package cards.base_set

import cards.ActionCard
import game.GameState
import game.Player

data class Cellar(override var owner: Player, val gameState: GameState) : ActionCard {
    override fun execute() {
        owner.addActions(1)
        val cardsToDiscard = gameState.game.askToPickCards(owner.hand, -1)
        for (card in cardsToDiscard) {
            owner.discardFromHand(card)
        }
        owner.draw(cardsToDiscard.size)
    }

    override val cost: Int
        get() = 2
}