package commands

import Player
import enums.BuyCardCode

class BuyCard(val player: Player, val code: BuyCardCode) : Command {
    override fun execute() {
        player.buy(code)
    }
}