package commands

import Player
import cards.Card

class PlayCard(val player: Player, val card: Card) : Command {
    override fun execute() {
        player.play(card)
    }

}