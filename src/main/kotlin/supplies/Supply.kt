package supplies

import cards.Card

data class Supply(val supplyPiles: ArrayList<CardPile>) {
    fun sell(card: Card): Card {
        return cardToPile(card).remove()
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
            if (pile.example::class == card::class) {
                return pile
            }
        }
        throw Exception("Card pile does not exist")
    }
}

