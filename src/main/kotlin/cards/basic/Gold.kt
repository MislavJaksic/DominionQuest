package cards.basic

import Player
import cards.TreasureCard

class Gold(override val owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(3)
    }

    override val cost: Int
        get() = 6
}