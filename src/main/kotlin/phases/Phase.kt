package phases

import Player
import cards.Card

/** Implements STATE pattern
 */
interface Phase {
    val player: Player
    fun play(card: Card)
}