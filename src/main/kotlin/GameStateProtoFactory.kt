import cards.basic.Copper
import cards.basic.Estate
import supplies.Supply
import supplies.SupplyProtoFactory

class GameStateProtoFactory {
    fun getGameState(playerCount:Int): GameState {
        val gameState = GameState(playerCount)

        val players = getPlayers(gameState)
        val supply = getSupply(gameState)

        gameState.players = players
        gameState.supply = supply

        return gameState
    }

    fun getPlayers(gameState: GameState): ArrayList<Player> {
        val players = ArrayList<Player>()
        for (x in 1..gameState.playerCount) {
            val player = Player(x.toString(), 0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
            for (y: Int in 1..3) {
                player.drawPile.add(Estate(player))
            }
            for (z: Int in 1..7) {
                player.drawPile.add(Copper(player))
            }
            player.shuffleDeck()
            player.cleanup()

            players.add(player)
        }
        return players
    }

    fun getSupply(gameState:GameState): Supply {
        val supplyPlayer = Player("supply", 0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
        val factory = SupplyProtoFactory(supplyPlayer, gameState.playerCount)
        return Supply(factory.getBasicPiles())
    }
}