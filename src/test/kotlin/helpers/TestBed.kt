package helpers

import cards.Card
import cards.TestActionCard
import cards.TestTreasureCard
import cards.TestVictoryCard
import commands.PlayCard
import controllers.CliController
import game.Game
import game.GameState
import game.Player
import supplies.CardPile
import supplies.Supply
import supplies.SupplyProtoFactory

class TestBed {
    fun getGameState(
        trash: ArrayList<Card> = ArrayList(),
    ): GameState {
        val gameState = GameState(trash)
        val players = ArrayList<Player>().apply { add(getPlayer(name = "first")) }
            .apply { add(getPlayer(name = "second")) }
        val supply = getSupply(getBasicSupplyPiles(getPlayer(name = "supply"), playerCount = 2))

        val controller = CliController()
        val game = Game(gameState, controller)

        gameState.game = game
        gameState.players = players
        gameState.supply = supply

        return gameState
    }

    fun getSupplyProtoFactory(
        supplyPlayer: Player = getPlayer(name = "supply"),
        playerCount: Int = 2
    ): SupplyProtoFactory {
        return SupplyProtoFactory(supplyPlayer, playerCount)
    }

    fun getBasicSupplyPiles(
        supplyPlayer: Player = getPlayer(name = "supply"),
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
        expectedDiscard: List<Card> = ArrayList(),
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