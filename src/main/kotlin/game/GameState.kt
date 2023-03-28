package game

import cards.Card
import controllers.Controller
import supplies.Supply

data class GameState(val playerCount: Int, val trash: ArrayList<Card>) {
    lateinit var players: ArrayList<Player>
    lateinit var supply: Supply
    lateinit var controller: Controller
}
