package supplies

import cards.Card

class SupplyPile(override val example: Card, override val stack: ArrayList<Card>) :CardPile {
    override fun add(card: Card) {
        stack.add(card)
    }
    override fun remove():Card {
        if (isNotEmpty()) {
            return stack.removeLast()
        }
        throw Exception("$example pile empty")
    }
    override fun isEmpty():Boolean {
        return isEmpty()
    }

    override fun isNotEmpty():Boolean {
        return !isEmpty()
    }
}