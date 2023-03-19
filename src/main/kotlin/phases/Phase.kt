package phases

import cards.Card
import game.Player

/** Implements STATE pattern
 */
interface Phase {
    val player: Player
    fun play(card: Card)
}