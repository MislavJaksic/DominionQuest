package helpers

import Player
import cards.Card

class DataSource {
    fun getPlayer(
        name: String = "test",
        actions: Int = 0,
        buys: Int = 0,
        coins: Int = 0,
        hand: ArrayList<Card> = ArrayList(),
        drawPile: ArrayList<Card> = ArrayList(),
        discardPile: ArrayList<Card> = ArrayList(),
        playArea: ArrayList<Card> = ArrayList()
    ): Player {
        return Player(name, actions, buys, coins, hand, drawPile, discardPile, playArea)
    }

    fun getPlayTestData(
        player: Player = getPlayer(),
        playCard: Card,
        expectedHand: ArrayList<Card> = ArrayList(),
        expectedPlayArea: ArrayList<Card> = ArrayList()
    ): PlayTestData {
        return PlayTestData(player, playCard, expectedHand, expectedPlayArea)
    }

    fun getBuyTestData(
        player: Player = getPlayer(),
        buyCard: Card,
        expectedDiscard: ArrayList<Card> = ArrayList(),
        expectedCoins: Int = 0,
        expectedBuys: Int = 0
    ): BuyTestData {
        return BuyTestData(player, buyCard, expectedDiscard, expectedCoins, expectedBuys)
    }
}