package supplies

import Player
import cards.Card
import cards.basic.Copper
import cards.basic.Gold
import cards.basic.Silver

class SupplyProtoFactory(val supplyPlayer: Player, val playerCount: Int) {

    /*fun getPile(code: BuyCardCode): ArrayList<Card> {
        code.
    }

    fun getSupplyForPlayers(code: SupplyCode):Supply {
        val supplyPiles: MutableMap<BuyCardCode, ArrayList<Card>> = mutableMapOf(Pair(BuyCardCode.COPPER, getPile(BuyCardCode.COPPER)))
        if (code == SupplyCode.BASIC) {
            return Supply(mutableMapOf(Pair(BuyCardCode.COPPER, )))
        } else if (code == SupplyCode.FIRST_GAME) {
            return Supply(mutableMapOf(Pair(BuyCardCode.COPPER, )))
        }
    }

    fun getBasicSupplyPairs(): ArrayList<Pair<BuyCardCode, ArrayList<Card>>> {
        val arrayList = ArrayList<Pair<BuyCardCode, ArrayList<Card>>>()
        for (i in 1..60) {

        }
        return
    }*/

    fun getCopper(): ArrayList<Card> {
        val cards = ArrayList<Card>()
        for (i in 1..60) {
            cards.add(Copper(supplyPlayer))
        }
        return cards
    }

    fun getSilver(): ArrayList<Card> {
        val cards = ArrayList<Card>()
        for (i in 1..40) {
            cards.add(Silver(supplyPlayer))
        }
        return cards
    }

    fun getGold(): ArrayList<Card> {
        val cards = ArrayList<Card>()
        for (i in 1..30) {
            cards.add(Gold(supplyPlayer))
        }
        return cards
    }
}