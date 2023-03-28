package cards.base_set

import cards.ActionCard
import cards.Card
import game.Player

data class Militia(override var owner: Player) : ActionCard {
    override val cost: Int
        get() = 4

    override fun execute() {
        val controller = owner.gameState.controller
        val otherPlayers = owner.gameState.players.filter { it !== owner }
        owner.addCoins(2)

        for (otherPlayer in otherPlayers) {
            val mustDiscard: Int = otherPlayer.hand.size - 3
            if (mustDiscard > 0) {
                val pickedCards: List<Card> = controller.askToPickCards(otherPlayer.hand, mustDiscard)
                for (card in pickedCards) {
                    otherPlayer.discard(card)
                }
            }
        }
    }
}