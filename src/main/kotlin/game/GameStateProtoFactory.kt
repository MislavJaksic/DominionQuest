package game

import cards.Card
import cards.basic.Copper
import cards.basic.Estate
import supplies.Supply
import supplies.SupplyProtoFactory

class GameStateProtoFactory {
    fun getGameState(playerCount: Int): GameState {
        val trash = ArrayList<Card>()
        val gameState = GameState(trash)

        val players = getPlayers(playerCount)
        val supply = getSupply(playerCount,gameState)

        gameState.players = players
        gameState.supply = supply

        return gameState
    }

    fun getPlayers(playerCount: Int): ArrayList<Player> {
        val players = ArrayList<Player>()
        for (x in 1..playerCount) {
            val player = Player(x.toString(), 0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
            for (y: Int in 1..3) {
                player.gainToDiscard(Estate(player))
            }
            for (z: Int in 1..7) {
                player.gainToDiscard(Copper(player))
            }
            player.shuffleDeck()
            player.cleanup()

            players.add(player)
        }
        return players
    }

    fun getSupply(playerCount: Int, gameState: GameState): Supply {
        val supplyPlayer = Player("supply", 0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
        val factory = SupplyProtoFactory(supplyPlayer, playerCount)
        return Supply(factory.getFirstGame(gameState))
    }
}