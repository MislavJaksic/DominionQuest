package cards.test

import Player
import cards.ActionCard
import cards.Card

class TestActionCard(override val owner: Player, override val cost: Int) :ActionCard {
    override fun execute() {
    }
}