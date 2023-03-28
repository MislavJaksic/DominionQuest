package helpers

import cards.Card
import cards.TestActionCard
import cards.TestTreasureCard
import cards.TestVictoryCard
import commands.PlayCard
import game.GameState
import game.Player
import supplies.CardPile
import supplies.Supply
import supplies.SupplyProtoFactory

class DataSource {
    fun getGameState(
        playerCount: Int = 2,
        trash: ArrayList<Card> = ArrayList<Card>(),
    ): GameState {
        val gameState = GameState(playerCount, trash)
        gameState.players = ArrayList<Player>().apply { add(getPlayer(gameState = gameState, name = "first")) }
            .apply { add(getPlayer(gameState = gameState, name = "second")) }
        gameState.supply = getSupply(getBasicSupplyPiles(getPlayer(gameState = gameState, name = "supply")))
        return gameState
    }

    fun getSupplyProtoFactory(
        supplyPlayer: Player = getPlayer(),
        playerCount: Int = 2
    ): SupplyProtoFactory {
        return SupplyProtoFactory(supplyPlayer, playerCount)
    }

    fun getBasicSupplyPiles(
        supplyPlayer: Player = getPlayer(),
        playerCount: Int = 2
    ): ArrayList<CardPile> {
        return getSupplyProtoFactory(supplyPlayer, playerCount).getBasicPiles()
    }

    fun getSupply(
        supplyPiles: ArrayList<CardPile> = getBasicSupplyPiles(),
    ): Supply {
        return Supply(supplyPiles)
    }

    fun getPlayer(
        gameState: GameState = getGameState(),
        name: String = "example",
        actions: Int = 0,
        buys: Int = 0,
        coins: Int = 0,
        hand: ArrayList<Card> = ArrayList(),
        drawPile: ArrayList<Card> = ArrayList(),
        discardPile: ArrayList<Card> = ArrayList(),
        playArea: ArrayList<Card> = ArrayList()
    ): Player {
        return Player(gameState, name, actions, buys, coins, hand, drawPile, discardPile, playArea)
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

    fun getBuyTestData(
        player: Player = getPlayer(),
        buyCard: Card,
        expectedDiscard: ArrayList<Card> = ArrayList(),
        expectedCoins: Int = 0,
        expectedBuys: Int = 0
    ): BuyTestData {
        return BuyTestData(player, buyCard, expectedDiscard, expectedCoins, expectedBuys)
    }

    fun getPlayCard(
        player: Player = getPlayer(),
        card: Card
    ): PlayCard {
        return PlayCard(player, card)
    }
}