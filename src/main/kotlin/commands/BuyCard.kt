package commands

import cards.Card
import game.GameState
import game.Player

data class BuyCard(val player: Player, val gameState: GameState, val card: Card) : Command {
    override fun execute() {
        player.buy(gameState.supply.sell(card))
    }

    override fun toString(): String {
        return "Buy(${card::class.simpleName})"
    }
}
