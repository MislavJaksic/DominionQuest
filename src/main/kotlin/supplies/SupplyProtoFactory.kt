package supplies

import cards.Card
import cards.base_set.*
import cards.basic.*
import game.Player

class SupplyProtoFactory(val supplyPlayer: Player, val playerCount: Int) {
    fun getBasicPiles(): ArrayList<CardPile> {
        return arrayListOf(
            getPileOfCards(Copper(supplyPlayer)),
            getPileOfCards(Silver(supplyPlayer)),
            getPileOfCards(Gold(supplyPlayer)),

            getPileOfCards(Estate(supplyPlayer)),
            getPileOfCards(Duchy(supplyPlayer)),
            getPileOfCards(Province(supplyPlayer)),
        )
    }

    fun getFirstGame(): ArrayList<CardPile> {
        val list = getBasicPiles()
        list.add(getPileOfCards(Cellar(supplyPlayer)))
        list.add(getPileOfCards(Moat(supplyPlayer)))
        list.add(getPileOfCards(Merchant(supplyPlayer)))
        list.add(getPileOfCards(Village(supplyPlayer)))
        list.add(getPileOfCards(Workshop(supplyPlayer)))

        list.add(getPileOfCards(Remodel(supplyPlayer)))
        list.add(getPileOfCards(Smithy(supplyPlayer)))
        list.add(getPileOfCards(Militia(supplyPlayer)))
        list.add(getPileOfCards(Market(supplyPlayer)))
        list.add(getPileOfCards(Mine(supplyPlayer)))
        return list
    }

    fun getPileOfCards(card: Card): SupplyPile {
        val list = ArrayList<Card>()
        return when (card) {
            is Copper -> SupplyPile(card.copy(), list.apply { repeat((60 - playerCount * 7)) { add(card.copy()) } })
            is Silver -> SupplyPile(card.copy(), list.apply { repeat(40) { add(card.copy()) } })
            is Gold -> SupplyPile(card.copy(), list.apply { repeat(30) { add(card.copy()) } })
            is Estate -> SupplyPile(
                card.copy(),
                list.apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy()) } })

            is Duchy -> SupplyPile(
                card.copy(),
                list.apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy()) } })

            is Province -> SupplyPile(
                card.copy(),
                list.apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy()) } })

            is Curse -> SupplyPile(
                card.copy(),
                list.apply { repeat(if (playerCount > 2) (playerCount - 1) * 10 else 10) { add(card.copy()) } })

            is Cellar -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Market -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Merchant -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Militia -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Mine -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Moat -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Remodel -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Smithy -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Village -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })
            is Workshop -> SupplyPile(card.copy(), list.apply { repeat(10) { add(card.copy()) } })

            else -> throw Exception("Card pile creation of $card not specified")
        }
    }
}