package helpers

import Player
import cards.Card

data class PlayTestData(
    val player: Player,
    val playCard: Card,
    val expectedHand: ArrayList<Card>,
    val expectedPlayArea: ArrayList<Card>
)


