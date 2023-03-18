import cards.basic.Copper
import cards.basic.Estate
import controllers.Controller
import supplies.Supply
import supplies.SupplyProtoFactory

data class GameState(val playerCount:Int) {
    lateinit var players: ArrayList<Player>
    lateinit var supply: Supply
    lateinit var game: Game
}
