package supplies

import Player
import cards.Card
import cards.basic.Copper
import cards.basic.Gold
import cards.basic.Silver
import enums.SupplyCardCode

class SupplyProtoFactory(val supplyPlayer: Player, val playerCount: Int) {
    fun getBasicPiles(): MutableMap<SupplyCardCode, CardPile> {
        return mutableMapOf(
            Pair(SupplyCardCode.COPPER, getCopper()),
            Pair(SupplyCardCode.SILVER, getSilver()),
            Pair(SupplyCardCode.GOLD, getGold()),
        )
    }

    fun getCopper(): SupplyPile {
        return SupplyPile(Copper(supplyPlayer), ArrayList<Card>().apply { repeat(60) { add(Copper(supplyPlayer)) } })
    }

    fun getSilver(): SupplyPile {
        return SupplyPile(Silver(supplyPlayer), ArrayList<Card>().apply { repeat(40) { add(Silver(supplyPlayer)) } })
    }

    fun getGold(): SupplyPile {
        return SupplyPile(Gold(supplyPlayer), ArrayList<Card>().apply { repeat(30) { add(Gold(supplyPlayer)) } })
    }
}