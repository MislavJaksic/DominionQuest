package cards

import Player

class TestActionCard(override val owner: Player, override val cost: Int) : ActionCard {
    override fun execute() {
    }
}