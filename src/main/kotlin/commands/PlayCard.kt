package commands

import cards.Card
import game.Player

data class PlayCard(val player: Player, val card: Card) : Command {
    override fun execute() {
        player.playFromHandToArea(card)
    }

    override fun toString(): String {
        return "Play(${card::class.simpleName})"
    }
}