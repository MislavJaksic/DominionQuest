package controllers

import cards.Card
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import commands.Command
import game.Game
import game.GameStateProtoFactory
import game.Player
import supplies.Supply


class CliController : CliktCommand(), Controller {
    val playerCount by option(help = "Number of players").int().default(1)

    override fun run() {
        val factory = GameStateProtoFactory()
        val gameState = factory.getGameState(playerCount)
        val game = Game(gameState, this)

        game.start()
    }

    override fun askToPickCommand(commands: ArrayList<Command>, player: Player, supply: Supply): Command {
        while (true) {
            printGameState(player, supply)
            println(getCommandsToString(commands))
            val input = prompt("What do you do?")

            if (input != null) {
                val number = input.toIntOrNull()
                if (number != null && number in (1..commands.size)) {
                    return commands[number - 1]
                }
            }
        }
    }

    override fun askToPickCards(cards: ArrayList<Card>, number: Int): ArrayList<Card> {
        while (true) {
            println(getCardsToString(cards))
            val input = prompt("List $number of characters seperated by whitespace to pick cards")
            if (input != null) {
                val inputs: List<String> = input.split(" ")
                val pickedCards = ArrayList<Card>()
                if (inputs.size == number || number == 0) {
                    for (input in inputs) {
                        val selector = input.toIntOrNull()
                        if (selector != null) {
                            cards.add(cards[selector - 1])
                        }
                    }
                    return pickedCards
                }
            }
        }

    }

    fun printGameState(player: Player, supply: Supply) {
        println(
            """
${getSupplyString(supply)}
${getPlayerString(player)}
"""
        )
    }

    fun getPlayerString(player: Player): String {
        return """
=== game.Player ${player.name}::${player.phase::class.java.simpleName} ===
actions  buys  coins
=${player.actions}       =${player.buys}    =${player.coins}
playArea=${getCardsToString(player.playArea)}
hand=${getCardsToString(player.hand)}
=== ===
"""
    }

    fun getSupplyString(supply: Supply): String {
        var representationString = "=== Supply ===\n"
        for ((code, array) in supply.supplyPiles.entries) {
            representationString += code
            representationString += " -> " + array.size().toString() + ", "
        }
        return representationString
    }


    fun getCardsToString(array: ArrayList<Card>): String {
        var string = ""
        for (item in array) {
            string += ", "
            string += item::class.simpleName
        }
        return string
    }

    fun getCommandsToString(array: ArrayList<Command>): String {
        var string = ""
        var count = 1
        for (item in array) {
            string += ", $count -> "
            string += "$item"
            count++
        }
        return string
    }

    override fun toString(): String {
        return "CliController()"
    }
}