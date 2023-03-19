package helpers

import cards.Card
import game.Player

data class PlayTestData(
    val player: Player,
    val playCard: Card,
    val expectedHand: ArrayList<Card>,
    val expectedPlayArea: ArrayList<Card>
)


