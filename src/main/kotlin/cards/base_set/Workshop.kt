package cards.base_set

import cards.ActionCard
import game.GameState
import game.Player

data class Workshop(override var owner: Player, val gameState: GameState) : ActionCard {
    override val cost: Int
        get() = 3

    override fun execute() {
        val supply = gameState.supply

        val cards = supply.getSoldCardsUpToCost(4)
        val gainedCard = gameState.game.askToPickCards(cards, 1)[0]
        owner.gainToDiscard(supply.sell(gainedCard))
    }
}