package supplies

import cards.Card
import cards.basic.*
import cards.vanilla.Cellar
import game.Player

class SupplyProtoFactory(val supplyPlayer: Player, val playerCount: Int) {
    fun getBasicPiles(): ArrayList<CardPile> {
        return arrayListOf(
            getCopper(),
            getSilver(),
            getGold(),
            getEstate(),
            getDuchy(),
            getProvince(),
        )
    }

    fun getFirstGame(): ArrayList<CardPile> {
        val list = getBasicPiles()
        list.add(getCellar())
        return list
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