package controllers

import Player
import commands.Command
import supplies.Supply

interface Controller {
    fun getCommandFrom(player: Player, supply: Supply): Command
    fun inputToPlayerCommand(input: String, player: Player, supply: Supply): Command
}