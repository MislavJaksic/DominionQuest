package commands

import enums.SupplyCardCode
import game.Player

data class BuyCard(val player: Player, val code: SupplyCardCode) : Command {
    override fun execute() {
        player.buy(player.gameState.supply.sell(code))
    }

    override fun toString(): String {
        return "BuyCard($code)"
    }
}
