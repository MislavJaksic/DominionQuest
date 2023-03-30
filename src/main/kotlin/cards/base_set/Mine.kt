package cards.base_set

import cards.ActionCard
import cards.TreasureCard
import game.GameState
import game.Player

data class Mine(override var owner: Player, val gameState: GameState) : ActionCard {
    override val cost: Int
        get() = 5

    override fun execute() {
        val supply = gameState.supply
        val game = gameState.game

        val trashedCard = game.askToPickCards(owner.hand.filterIsInstance<TreasureCard>(), 1)[0]
        gameState.game.playerTrashesCard(owner, trashedCard)

        val cards = supply.getSoldCardsUpToCost(trashedCard.cost + 3).filterIsInstance<TreasureCard>()
        val gainedCard = game.askToPickCards(cards, 1)[0]

        owner.gainToDiscard(supply.sell(gainedCard))
    }
}