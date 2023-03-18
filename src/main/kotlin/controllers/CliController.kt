package controllers

import Game
import GameState
import GameStateProtoFactory
import Player
import cards.Card
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import commands.*
import enums.SupplyCardCode
import supplies.Supply


class CliController : CliktCommand(), Controller {
    val playerCount by option(help = "Number of players").int().default(1)

    override fun run() {
        val factory = GameStateProtoFactory()
        val gameState = factory.getGameState(playerCount)
        val game = Game(gameState, this)
        
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