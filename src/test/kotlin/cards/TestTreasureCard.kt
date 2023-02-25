package cards

import Player

class TestTreasureCard(override val owner: Player, override val cost: Int) : TreasureCard {
    override fun execute() {
    }
}