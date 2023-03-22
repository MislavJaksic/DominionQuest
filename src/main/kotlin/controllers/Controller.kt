package controllers

import cards.Card
import commands.Command
import game.Player
import supplies.Supply

interface Controller {
    fun askToPickCommand(commands: List<Command>, player: Player, supply: Supply): Command
    fun askToPickCards(cards: List<Card>, number: Int): List<Card>
}