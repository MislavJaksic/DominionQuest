package controllers

import Game
import Player
import cards.Card
import cards.basic.Copper
import cards.basic.Estate
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import commands.*
import enums.SupplyCardCode
import supplies.CardPile
import supplies.Supply


class CliController : CliktCommand(), Controller {
    val playerCount by option(help = "Number of players").int().default(1)

    override fun run() {
        val players: ArrayList<Player> = ArrayList()

        val supplyPiles: MutableMap<SupplyCardCode, CardPile> = mutableMapOf()
        val supply = Supply(supplyPiles)

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

        val game = Game(players, supply, this)
        game.start()
    }

    override fun getCommandFrom(player: Player, supply: Supply): Command {
        while (true) {
            printStateOf(player)
            val input = prompt("What do you do?")

            if (input != null) {
                return inputToPlayerCommand(input, player, supply)
            }
            return NullCommand()
        }
    }

    override fun inputToPlayerCommand(input: String, player: Player, supply: Supply): Command {
        if (input == "-1") return Surrender()
        if (input == "0")
            return NextPhase(player, isTurnEnd = false)
        if (player.hand.isNotEmpty()) {
            val number = input.toIntOrNull()
            if (number != null && number in (1..player.hand.size)) {
                return PlayCard(player, player.hand[number - 1])
            }
        }
        if (input == "q") return BuyCardFromSupply(player, SupplyCardCode.COPPER, supply)
        if (input == "w") return BuyCardFromSupply(player, SupplyCardCode.SILVER, supply)
        if (input == "e") return BuyCardFromSupply(player, SupplyCardCode.GOLD, supply)
        if (input == "r") return BuyCardFromSupply(player, SupplyCardCode.ESTATE, supply)
        if (input == "t") return BuyCardFromSupply(player, SupplyCardCode.DUCHY, supply)
        if (input == "z") return BuyCardFromSupply(player, SupplyCardCode.PROVINCE, supply)
        if (input == "a") return BuyCardFromSupply(player, SupplyCardCode.FIRST, supply)
        if (input == "s") return BuyCardFromSupply(player, SupplyCardCode.SECOND, supply)
        if (input == "d") return BuyCardFromSupply(player, SupplyCardCode.THIRD, supply)
        if (input == "f") return BuyCardFromSupply(player, SupplyCardCode.FOURTH, supply)
        if (input == "g") return BuyCardFromSupply(player, SupplyCardCode.FIFTH, supply)
        if (input == "y") return BuyCardFromSupply(player, SupplyCardCode.SIXTH, supply)
        if (input == "x") return BuyCardFromSupply(player, SupplyCardCode.SEVENTH, supply)
        if (input == "c") return BuyCardFromSupply(player, SupplyCardCode.EIGHTH, supply)
        if (input == "v") return BuyCardFromSupply(player, SupplyCardCode.NINTH, supply)
        if (input == "b") return BuyCardFromSupply(player, SupplyCardCode.TENTH, supply)

        return NullCommand()
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