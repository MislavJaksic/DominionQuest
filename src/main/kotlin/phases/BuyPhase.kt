package phases

import cards.Card
import cards.TreasureCard
import game.Player

data class BuyPhase(override val player: Player) : Phase {
    override fun play(card: Card) {
        if (card is TreasureCard) {
            player.hand.remove(card)
            player.playArea.add(card)
            card.execute()
        } else {
            throw Exception("Can only play treasure cards in buy phase")
        }
    }
}