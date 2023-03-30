package game

import cards.Card
import controllers.Controller
import supplies.Supply

data class GameState(val trash: ArrayList<Card>) {
    lateinit var game: Game
    lateinit var players: ArrayList<Player>
    lateinit var supply: Supply
}
