package cards

import game.Player

data class TestActionCard(override var owner: Player, override val cost: Int) : ActionCard {
    override fun execute() {
    }
}