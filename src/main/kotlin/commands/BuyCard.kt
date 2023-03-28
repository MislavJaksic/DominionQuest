package commands

import cards.Card
import game.Player

data class BuyCard(val player: Player, val card: Card) : Command {
    override fun execute() {
        player.buy(player.gameState.supply.sell(card))
    }

    override fun toString(): String {
        return "Buy(${card::class.simpleName})"
    }
}
