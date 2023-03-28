package supplies

import cards.Card

data class Supply(val supplyPiles: ArrayList<CardPile>) {

    fun sell(card: Card): Card {
        return cardToPile(card).remove()
    }

    fun getSoldCardsUpToCost(cost: Int): ArrayList<Card> {
        val cards = ArrayList<Card>()
        for (pile in supplyPiles) {
            if (pile.example.cost <= cost && pile.isNotEmpty()) {
                cards.add(pile.example)
            }
        }
        return cards
    }

    fun isCardSold(card: Card): Boolean {
        if (isCardInSupply(card)) {
            if (cardToPile(card).isNotEmpty()) {
                return true
            }
        }
        return false
    }

    fun isCardInSupply(card: Card): Boolean {
        return try {
            cardToPile(card)
            true
        } catch (_: Exception) {
            false
        }
    }

    fun cardToPile(card: Card): CardPile {
        for (pile in supplyPiles) {
            if (pile.example::class.java == card::class.java) {
                return pile
            }
        }
        throw Exception("Card pile does not exist")
    }
}

