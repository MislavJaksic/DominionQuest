package controllers

import Player

interface Controller {
    fun getInputFrom(player: Player): Int
}