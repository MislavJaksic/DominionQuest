package cards.basic

import cards.TreasureCard
import game.Player

data class Silver(override var owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(2)
    }

    override val cost: Int
        get() = 3
}