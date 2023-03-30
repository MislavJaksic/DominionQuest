package cards

import game.Player

data class TestVictoryCard(override var owner: Player, override val cost: Int, override val points: Int) : VictoryCard