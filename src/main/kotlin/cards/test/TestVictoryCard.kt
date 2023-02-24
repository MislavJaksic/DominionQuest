package cards.test

import Player
import cards.VictoryCard

class TestVictoryCard(override val owner: Player, override val cost: Int, override val points: Int) : VictoryCard