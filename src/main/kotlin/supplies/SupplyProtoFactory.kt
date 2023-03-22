package supplies

import cards.Card
import cards.basic.*
import cards.vanilla.Cellar
import enums.SupplyCardCode
import game.Player

class SupplyProtoFactory(val supplyPlayer: Player, val playerCount: Int) {
    fun getBasicPiles(): MutableMap<SupplyCardCode, CardPile> {
        return mutableMapOf(
            Pair(SupplyCardCode.COPPER, getCopper()),
            Pair(SupplyCardCode.SILVER, getSilver()),
            Pair(SupplyCardCode.GOLD, getGold()),
            Pair(SupplyCardCode.ESTATE, getEstate()),
            Pair(SupplyCardCode.DUCHY, getDuchy()),
            Pair(SupplyCardCode.PROVINCE, getProvince()),
        )
    }

    fun getFirstGame(): MutableMap<SupplyCardCode, CardPile> {
        val map = getBasicPiles()
        map.set(SupplyCardCode.FIRST, getCellar())
        return map
    }

    fun getCopper(): SupplyPile {
        return SupplyPile(
            Copper(supplyPlayer),
            ArrayList<Card>().apply { repeat((60 - playerCount * 7)) { add(Copper(supplyPlayer)) } })
    }

    fun getSilver(): SupplyPile {
        return SupplyPile(Silver(supplyPlayer), ArrayList<Card>().apply { repeat(40) { add(Silver(supplyPlayer)) } })
    }

    fun getGold(): SupplyPile {
        return SupplyPile(Gold(supplyPlayer), ArrayList<Card>().apply { repeat(30) { add(Gold(supplyPlayer)) } })
    }

    fun getEstate(): SupplyPile {
        return SupplyPile(
            Estate(supplyPlayer),
            ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(Estate(supplyPlayer)) } })
    }

    fun getDuchy(): SupplyPile {
        return SupplyPile(
            Duchy(supplyPlayer),
            ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(Duchy(supplyPlayer)) } })
    }

    fun getProvince(): SupplyPile {
        return SupplyPile(
            Province(supplyPlayer),
            ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(Province(supplyPlayer)) } })
    }

    fun getCellar(): SupplyPile {
        return SupplyPile(
            Cellar(supplyPlayer),
            ArrayList<Card>().apply { repeat(10) { add(Cellar(supplyPlayer)) } })
    }
}