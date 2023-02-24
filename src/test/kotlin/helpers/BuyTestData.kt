package helpers

import Player
import cards.Card

data class BuyTestData(
    val player: Player,
    val buyCard: Card,
    val expectedDiscard: ArrayList<Card>,
    val expectedCoins: Int,
    val expectedBuys: Int,
)
