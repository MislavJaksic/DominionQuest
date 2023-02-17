package cards.base

import Player
import cards.TreasureCard

class Copper(override val player: Player) : TreasureCard {
    override fun execute() {
        player.incrementCoins()
    }

    override val cost: Int
        get() = 0
}