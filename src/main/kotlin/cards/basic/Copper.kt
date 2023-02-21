package cards.basic

import Player
import cards.TreasureCard

class Copper(override val owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(1)
    }

    override val cost: Int
        get() = 0
}