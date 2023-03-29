package cards

import game.Player

data class TestTreasureCard(override var owner: Player, override val cost: Int) : TreasureCard {
    override fun execute() {
    }
}