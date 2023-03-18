package phases

import Player
import cards.ActionCard
import cards.Card

data class ActionPhase(override val player: Player) : Phase {
    override fun play(card: Card) {
        if (card is ActionCard && player.actions > 0) {
            player.addActions(-1)
            player.hand.remove(card)
            player.playArea.add(card)
            card.execute()
        }
    }
}