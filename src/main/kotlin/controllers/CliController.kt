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
        gameState.controller = this
        val game = Game(gameState, this)

        game.start()
    }

    override fun askToPickCommand(commands: List<Command>, player: Player, supply: Supply): Command {
        printGameState(player, supply)
        printCommands(commands)

        return prompt("What do you do?") { inputToCommand(it, commands) }!!
    }

    fun inputToCommand(input: String?, commands: List<Command>): Command {
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
    override fun askToPickCards(cards: List<Card>, number: Int): List<Card> {
        println(getCardsToString(cards))

        return prompt("Select ${if (number == -1) "any number of" else "up to $number of"} cards:") {
            inputToCards(
                it,
                cards,
                number
            )
        }!!
    }

    fun inputToCards(input: String?, cards: List<Card>, number: Int): List<Card> {
        if (input != null) {
            val inputs: List<String> = input.split(" ")
            if (inputs.size == number || number == -1) {
                val pickedCards = ArrayList<Card>()
                for (elements in inputs) {
                    val selector = elements.toIntOrNull()
                    if (selector != null) {
                        if (selector in (1..cards.size)) {
                            pickedCards.add(cards[selector - 1])
                        } else {
                            throw UsageError("Input must be between 1 and ${cards.size}")
                        }
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

    fun printCommands(commands: List<Command>) {
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
        for (pile in supply.supplyPiles) {
            representationString += pile.example::class.simpleName
            representationString += " -> " + pile.size().toString() + ", "
        }
        return representationString
    }

    fun getCardsToString(array: List<Card>): String {
        var string = ""
        for (item in array) {
            string += ", "
            string += item::class.simpleName
        }
        return string
    }

    fun getCommandsToString(array: List<Command>): String {
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