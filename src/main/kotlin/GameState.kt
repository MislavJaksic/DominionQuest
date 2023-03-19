import controllers.Controller
import supplies.Supply

data class GameState(val playerCount: Int) {
    lateinit var players: ArrayList<Player>
    lateinit var supply: Supply
    lateinit var game: Game
    lateinit var controller: Controller
}
