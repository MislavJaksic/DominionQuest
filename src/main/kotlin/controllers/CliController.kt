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


class CliController : CliktCommand(), Controller {
    val playerCount by option(help = "Number of players").int().default(1)

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

    override fun getInputFrom(player: Player): Int {
        while (true) {
            printStateOf(player)
            val inputValue = prompt("What do you do?") {
                it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
            }

            if (inputValue != null && inputValue in -1..player.hand.size) {
                return inputValue
            }
        }
    }

    fun printStateOf(player: Player) {
        println(
            """=== Player ${player.name}::${player.phase::class.java.simpleName} ===
actions  buys  coins
=${player.actions}       =${player.buys}    =${player.coins}
playArea=${arrayToFlatString(player.playArea)}
hand=${arrayToCommandString(player.hand)}
commands= -1 -> exit, 0 -> next phase
=== ==="""
        )
    }

    fun arrayToFlatString(array: ArrayList<Card>): String {
        var string = ""
        for (item in array) {
            string += ", "
            string += item::class.simpleName
        }
        return string
    }

    fun arrayToCommandString(array: ArrayList<Card>): String {
        var string = ""
        var count = 1
        for (item in array) {
            string += ", $count -> "
            string += item::class.simpleName
            count++
        }
        return string
    }
}