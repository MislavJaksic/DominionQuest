import cards.Card
import enums.BuyCardCode

class Supply(val supplyPiles: MutableMap<BuyCardCode, ArrayList<Card>>) {
    /*fun get(card:Card):Card? {
        val key: String = card::class.simpleName ?: throw Exception("Card doesn't have simpleName")

        if (!supplyPiles.containsKey(key)) {
            throw Exception("Cannot get card that doesn't exist in supply")
        }

        if (supplyPiles.getOrDefault(key, 0) > 0) {
            supplyPiles[key]?.minus(1)
            return card
        }
        return null
    }*/

    fun sell(code: BuyCardCode): Card? {
        if (isSold(code)) {
            return supplyPiles[code]?.removeLast() ?: throw Exception("Cannot sell")
        }
        return null /* DONT RETURN ERROR CODES!!! */
    }

    fun codeToCard(code: BuyCardCode):Card? {
        if (isSold(code)) {

        }
        return null
    }

    fun isSold(code: BuyCardCode): Boolean {
        if (supplyPiles[code]?.isNotEmpty() == true) {
            return true
        }
        return false
    }
}

