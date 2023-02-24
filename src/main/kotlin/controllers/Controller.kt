package controllers

import Player
import commands.Command

interface Controller {
    fun getCommandFrom(player: Player): Command
}