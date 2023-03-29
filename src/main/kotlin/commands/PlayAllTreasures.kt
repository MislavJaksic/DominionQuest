package commands

import cards.TreasureCard
import game.Player

data class PlayAllTreasures(val player: Player) : Command {
    override fun execute() {
        val treasureCards = player.hand.filterIsInstance<TreasureCard>()
        for (card in treasureCards) {
            player.playFromHandToArea(card)
        }
    }
}
