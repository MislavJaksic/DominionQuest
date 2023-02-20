package cards.base

import Player
import cards.Card

class TestCard(override val owner: Player, override val cost: Int) :Card {
}