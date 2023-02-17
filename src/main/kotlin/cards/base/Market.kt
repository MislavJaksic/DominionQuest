package cards.base

import Player
import cards.ActionCard

class Market(override val player: Player): ActionCard {
    override val cost: Int
        get() = 5

    override fun execute() {
        player.draw()
        player.incrementActions()
        player.incrementBuys()
        player.incrementCoins()
    }

}