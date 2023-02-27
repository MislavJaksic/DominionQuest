package cards.basic

import Player
import cards.TreasureCard

class Silver(override var owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(2)
    }

    override val cost: Int
        get() = 3
}