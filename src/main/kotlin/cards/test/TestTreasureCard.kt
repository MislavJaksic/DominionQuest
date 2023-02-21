package cards.test

import Player
import cards.TreasureCard

class TestTreasureCard(override val owner: Player, override val cost: Int) : TreasureCard {
    override fun execute() {
    }
}