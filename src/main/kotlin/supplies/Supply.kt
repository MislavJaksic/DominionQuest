package supplies

import cards.Card
import enums.SupplyCardCode

data class Supply(val supplyPiles: MutableMap<SupplyCardCode, CardPile>) {
    fun sell(code: SupplyCardCode): Card {
        return supplyPiles[code]!!.remove()
    }

    fun codeToCard(code: SupplyCardCode): Card {
        return supplyPiles[code]!!.example
    }

    fun isCardInSupply(code: SupplyCardCode): Boolean {
        if (isCodeInSupply(code)) {
            if (supplyPiles[code]!!.isNotEmpty()) {
                return true
            }
        }
        return false
    }

    fun isCodeInSupply(code: SupplyCardCode): Boolean {
        return supplyPiles.containsKey(code)
    }
}

