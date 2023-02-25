package phases

import Player
import cards.Card
import cards.TreasureCard

data class BuyPhase(override val player: Player) : Phase {
    override fun play(card: Card) {
        println(card)
        if (card is TreasureCard) {
            println(card)
            player.hand.remove(card)
            player.playArea.add(card)
            card.execute()
        }
    }
}