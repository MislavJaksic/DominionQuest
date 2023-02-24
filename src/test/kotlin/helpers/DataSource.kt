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
        player: Player,
        playCard: Card,
        expectedHand: ArrayList<Card>,
        expectedPlayArea: ArrayList<Card>
    ): PlayTestData {
        return PlayTestData(player, playCard, expectedHand, expectedPlayArea)
    }
}