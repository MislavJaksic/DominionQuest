package controllers

import cards.Card
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError
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
        printGameState(player, supply)
        printCommands(commands)

        return prompt("What do you do?") { inputToCommand(it, commands) }!!
    }

    fun inputToCommand(input: String?, commands: ArrayList<Command>): Command {
        if (input != null) {
            val number = input.toIntOrNull()
            if (number != null) {
                if (number in (1..commands.size)) {
                    return commands[number - 1]
                }
                throw UsageError("Input must be between 1 and ${commands.size}")
            }
            throw UsageError("Input must be a number")
        }
        throw UsageError("Input cannot be null")
    }

    /*
    If number is -1, than the player can pick any number of cards. Otherwise, the player has to pick an exact number of cards
     */
    override fun askToPickCards(cards: ArrayList<Card>, number: Int): ArrayList<Card> {
        println(getCardsToString(cards))

        return prompt("Select up to $number cards:") { inputToCards(it, cards, number) }!!
    }

    fun inputToCards(input: String?, cards: ArrayList<Card>, number: Int): ArrayList<Card> {
        if (input != null) {
            val inputs: List<String> = input.split(" ")
            if (inputs.size == number || number == -1) {
                val pickedCards = ArrayList<Card>()
                for (elements in inputs) {
                    val selector = elements.toIntOrNull()
                    if (selector != null) {
                        pickedCards.add(cards[selector - 1])
                    } else {
                        throw UsageError("All inputs must be numbers")
                    }
                }
                return pickedCards
            }
            throw UsageError("Select $number cards not ${inputs.size}")
        }
        throw UsageError("Input cannot be null")
    }

    fun printGameState(player: Player, supply: Supply) {
        println(
            """
${getSupplyString(supply)}
${getPlayerString(player)}
"""
        )
    }

    fun printCommands(commands: ArrayList<Command>) {
        println(getCommandsToString(commands))
    }

    fun getPlayerString(player: Player): String {
        return """
=== Player ${player.name}::${player.phase::class.java.simpleName} ===
actions  buys  coins
=${player.actions}       =${player.buys}    =${player.coins}
playArea=${getCardsToString(player.playArea)}
hand=${getCardsToString(player.hand)}"""
    }

    fun getSupplyString(supply: Supply): String {
        var representationString = "=== Supply ===\n"
        for ((code, array) in supply.supplyPiles.entries) {
            representationString += supply.codeToCard(code)::class.simpleName
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
        var string = "=== Commands ===\n"
        var count = 1
        for (item in array) {
            string += ", $count -> "
            string += "$item"
            count++
        }
        return string + "\n"
    }

    override fun toString(): String {
        return "CliController()"
    }
}