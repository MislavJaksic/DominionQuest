package commands

import cards.Card
import game.Player

data class PlayCard(val player: Player, val card: Card) : Command {
    override fun execute() {
        player.play(card)
    }

    override fun toString(): String {
        return "PlayCard(card=${card::class.simpleName})"
    }
}