package phases

import Player
import cards.Card
/** Implements State Pattern
*/
interface Phase {
    val player: Player
    fun play(card: Card)
}