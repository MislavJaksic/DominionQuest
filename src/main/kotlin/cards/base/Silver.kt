package cards.base

import Player
import cards.TreasureCard

class Silver(override val player: Player) : TreasureCard {
    override fun execute() {
        player.incrementCoins()
        player.incrementCoins()
    }

    override val cost: Int
        get() = 3
}