package cards

import game.Player

class TestTreasureCard(override var owner: Player, override val cost: Int) : TreasureCard {
    override fun execute() {
    }
}