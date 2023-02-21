package phases

import Player
import cards.Card
import cards.TreasureCard

class BuyPhase(override val player: Player) : Phase {
    override fun play(card: Card) {
        if (card is TreasureCard) {
            player.hand.remove(card)
            player.playArea.add(card)
            card.execute()
        }
    }
}