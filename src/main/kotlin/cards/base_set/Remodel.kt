package cards.base_set

import cards.ActionCard
import game.GameState
import game.Player

data class Remodel(override var owner: Player, val gameState: GameState) : ActionCard {
    override val cost: Int
        get() = 4

    override fun execute() {
        val supply = gameState.supply
        val game = gameState.game

        val trashedCard = game.askToPickCards(owner.hand, 1)[0]
        gameState.game.playerTrashesCard(owner, trashedCard)

        val cards = supply.getSoldCardsUpToCost(trashedCard.cost + 2)
        val gainedCard = game.askToPickCards(cards, 1)[0]

        owner.gainToDiscard(supply.sell(gainedCard))
    }
}