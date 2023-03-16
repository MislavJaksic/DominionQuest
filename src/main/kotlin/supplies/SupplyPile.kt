package supplies

import cards.Card

class SupplyPile(override val example: Card, override val stack: ArrayList<Card>) : CardPile {
    override fun add(card: Card) {
        stack.add(card)
    }

    override fun remove(): Card {
        return stack.removeLast()
    }

    override fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    override fun isNotEmpty(): Boolean {
        return !isEmpty()
    }

    override fun size(): Int {
        return stack.size
    }
}