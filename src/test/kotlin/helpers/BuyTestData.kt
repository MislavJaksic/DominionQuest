package helpers

import cards.Card
import game.Player

data class BuyTestData(
    val player: Player,
    val buyCard: Card,
    val expectedDiscard: ArrayList<Card>,
    val expectedCoins: Int,
    val expectedBuys: Int,
)
