package cards.basic

import cards.TreasureCard
import game.Player

data class Copper(override var owner: Player) : TreasureCard {

    override fun execute() {
        owner.addCoins(1)
    }

    override val cost: Int
        get() = 0
}