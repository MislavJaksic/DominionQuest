package supplies

import cards.Card

interface CardPile {
    val example: Card
    val stack: ArrayList<Card>

    fun add(card: Card)
    fun remove(): Card
    fun isEmpty(): Boolean
    fun isNotEmpty(): Boolean
}