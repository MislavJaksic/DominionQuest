package supplies

import cards.Card
import enums.SupplyCardCode

class Supply(val supplyPiles: MutableMap<SupplyCardCode, CardPile>) {
    fun sell(code: SupplyCardCode): Card {
        if (isCardInSupply(code)) {
            return supplyPiles[code]!!.remove()
        }
        throw Exception("$code card not in supply")
    }

    fun codeToCard(code: SupplyCardCode): Card {
        if (isCodeInSupply(code)) {
            return supplyPiles[code]!!.example
        }
        throw Exception("$code not in supply")
    }

    fun isCardInSupply(code: SupplyCardCode): Boolean {
        if (isCodeInSupply(code)) {
            if (supplyPiles[code]!!.isNotEmpty()) {
                return true
            }
        }
        return false
    }

    fun isCodeInSupply(code:SupplyCardCode):Boolean {
        return supplyPiles.containsKey(code)
    }
}

