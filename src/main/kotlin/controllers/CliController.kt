package controllers

import Game
import Player
import Supply
import cards.Card
import cards.basic.Copper
import cards.basic.Estate
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import commands.*
import enums.BuyCardCode


class CliController : CliktCommand(), Controller {
    val playerCount by option(help = "Number of players").int().default(1)

    override fun run() {
        val players: ArrayList<Player> = ArrayList()

        val supplyPiles: MutableMap<BuyCardCode, ArrayList<Card>> = mutableMapOf()
        val supply = Supply(supplyPiles)

        for (x in 1..playerCount) {
            val player = Player(x.toString(), supply, 0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
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

    override fun getCommandFrom(player: Player): Command {
        while (true) {
            printStateOf(player)
            val input = prompt("What do you do?")

            val command = input?.let { inputToPlayerCommand(it, player) }
            command?.let { return command }
        }
    }

    fun inputToPlayerCommand(input: String, player: Player): Command? {
        if (input == "-1") return Surrender()
        if (input == "0")
            return NextPhase(player, isTurnEnd = false)
        if (player.hand.isNotEmpty()) {
            val number = input.toIntOrNull()
            if (number != null && number in (1..player.hand.size)) {
                return PlayCard(player, player.hand[number - 1])
            }
        }
        if (input == "q") return BuyCard(player, BuyCardCode.COPPER)
        if (input == "w") return BuyCard(player, BuyCardCode.SILVER)
        if (input == "e") return BuyCard(player, BuyCardCode.GOLD)
        if (input == "r") return BuyCard(player, BuyCardCode.ESTATE)
        if (input == "t") return BuyCard(player, BuyCardCode.DUCHY)
        if (input == "z") return BuyCard(player, BuyCardCode.PROVINCE)
        if (input == "a") return BuyCard(player, BuyCardCode.FIRST)
        if (input == "s") return BuyCard(player, BuyCardCode.SECOND)
        if (input == "d") return BuyCard(player, BuyCardCode.THIRD)
        if (input == "f") return BuyCard(player, BuyCardCode.FOURTH)
        if (input == "g") return BuyCard(player, BuyCardCode.FIFTH)
        if (input == "y") return BuyCard(player, BuyCardCode.SIXTH)
        if (input == "x") return BuyCard(player, BuyCardCode.SEVENTH)
        if (input == "c") return BuyCard(player, BuyCardCode.EIGHTH)
        if (input == "v") return BuyCard(player, BuyCardCode.NINTH)
        if (input == "b") return BuyCard(player, BuyCardCode.TENTH)

        return null
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

    /*fun printStateOf(kingdom: Kingdom) {
        println(
            """=== Player ${player.name}::${player.phase::class.java.simpleName} ===
actions  buys  coins
=${player.actions}       =${player.buys}    =${player.coins}
playArea=${arrayToFlatString(player.playArea)}
hand=${arrayToCommandString(player.hand)}
commands= -1 -> exit, 0 -> next phase
=== ==="""
        )
    }*/

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