package cards.basic

import Player
import cards.TreasureCard

class Gold(override var owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(3)
    }

    override val cost: Int
        get() = 6
}