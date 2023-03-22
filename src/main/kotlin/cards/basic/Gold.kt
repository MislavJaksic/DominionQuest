package cards.basic

import cards.TreasureCard
import game.Player

class Gold(override var owner: Player) : TreasureCard {
    override fun execute() {
        owner.addCoins(3)
    }

    override val cost: Int
        get() = 6
}