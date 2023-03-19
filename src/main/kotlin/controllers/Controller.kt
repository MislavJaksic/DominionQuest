package controllers

import cards.Card
import commands.Command
import game.Player
import supplies.Supply

interface Controller {
    /*fun getCommandFrom(player: Player, supply: Supply): Command
    fun inputToPlayerCommand(input: String, player: Player, supply: Supply): Command*/
    fun askToPickCommand(commands: ArrayList<Command>, player: Player, supply: Supply): Command
    fun askToPickCards(cards: ArrayList<Card>, number: Int): ArrayList<Card>
}