package cards.base_set

import cards.ActionCard
import cards.Card
import game.GameState
import game.Player

data class Militia(override var owner: Player, val gameState: GameState) : ActionCard {
    override val cost: Int
        get() = 4

    override fun execute() {
        val otherPlayers = gameState.players.filter { it !== owner }
        owner.addCoins(2)

        for (otherPlayer in otherPlayers) {
            val mustDiscard: Int = otherPlayer.hand.size - 3
            if (mustDiscard > 0) {
                val pickedCards: List<Card> = gameState.game.askToPickCards(otherPlayer.hand, mustDiscard)
                for (card in pickedCards) {
                    otherPlayer.discardFromHand(card)
                }
            }
        }
    }
}