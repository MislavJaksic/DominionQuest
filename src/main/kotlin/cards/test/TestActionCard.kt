package cards.test

import Player
import cards.ActionCard

class TestActionCard(override val owner: Player, override val cost: Int) : ActionCard {
    override fun execute() {
    }
}