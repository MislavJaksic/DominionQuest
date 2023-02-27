package helpers

import Player
import cards.Card
import cards.TestActionCard
import cards.TestTreasureCard
import cards.TestVictoryCard
import commands.Command
import commands.NextPhase
import commands.PlayCard
import enums.SupplyCardCode
import supplies.Supply

class DataSource {
    /*fun get supplyPiles(

    ) : MutableMap<BuyCardCode, ArrayList<Card>> {
        return mutableMapOf<BuyCardCode, ArrayList<Card>>()
    }*/

    fun getSupply(
        supplyPiles: MutableMap<SupplyCardCode, ArrayList<Card>> = mutableMapOf()
    ): Supply {
        return Supply(supplyPiles)
    }

    fun getPlayer(
        name: String = "cards",
        supply: Supply = getSupply(),
        actions: Int = 0,
        buys: Int = 0,
        coins: Int = 0,
        hand: ArrayList<Card> = ArrayList(),
        drawPile: ArrayList<Card> = ArrayList(),
        discardPile: ArrayList<Card> = ArrayList(),
        playArea: ArrayList<Card> = ArrayList()
    ): Player {
        return Player(name, supply, actions, buys, coins, hand, drawPile, discardPile, playArea)
    }

    fun getActionCard(owner: Player = getPlayer(), cost: Int = 0): TestActionCard {
        return TestActionCard(owner, cost)
    }

    fun getTreasureCard(owner: Player = getPlayer(), cost: Int = 0): TestTreasureCard {
        return TestTreasureCard(owner, cost)
    }

    fun getVictoryCard(owner: Player = getPlayer(), cost: Int = 0, points: Int = 0): TestVictoryCard {
        return TestVictoryCard(owner, cost, points)
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

    fun getInputPlayerCommandTestData(
        input: String = "",
        player: Player = getPlayer(),
        command: Command?
    ): InputPlayerCommandTestData {
        return InputPlayerCommandTestData(input, player, command)
    }

    fun getNextPhase(
        player: Player = getPlayer(),
        isTurnEnd: Boolean = false
    ): NextPhase {
        return NextPhase(player, isTurnEnd)
    }

    fun getPlayCard(
        player: Player = getPlayer(),
        card: Card
    ): PlayCard {
        return PlayCard(player, card)
    }
}