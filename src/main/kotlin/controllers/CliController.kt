package controllers

import Game
import Player
import cards.Card
import cards.basic.Copper
import cards.basic.Estate
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int


class CliController: CliktCommand(), Controller {
    val playerCount by option(help="Number of players").int().default(1)

    override fun run() {
        val players: ArrayList<Player> = ArrayList()
        for (x in 1..playerCount) {
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

        val game = Game(players, this)
        game.start()
    }
    override fun getInputFrom(player: Player):Int {
        while (true) {
            printStateOf(player)
            val inputValue = prompt("What do you do?") {
                it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
            }

            if (inputValue != null && inputValue in -1 .. player.hand.size) {
                return inputValue
            }
        }
    }

    fun printStateOf(player:Player) {
        println("""Player(
actions=${player.actions}
buys=${player.buys}
coins=${player.coins}
hand=${arrayToString(player.hand)}
playArea=${arrayToString(player.playArea)}
)""")
    }
    fun arrayToString(array: ArrayList<Card>): String {
        var string = ""
        for(item in array){
            string += "\n    "
            string += item.toString()
        }
        return string
    }
}