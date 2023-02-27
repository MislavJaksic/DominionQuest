package cards

import Player

class TestActionCard(override var owner: Player, override val cost: Int) : ActionCard {
    override fun execute() {
    }
}