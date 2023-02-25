package cards

import Player

class TestVictoryCard(override val owner: Player, override val cost: Int, override val points: Int) : VictoryCard