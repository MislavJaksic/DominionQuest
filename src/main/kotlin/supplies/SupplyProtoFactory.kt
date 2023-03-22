package supplies

import cards.Card
import cards.base_set.Cellar
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
        return list
    }

    fun getPileOfCards(card: Card): SupplyPile {
        return when (card) {
            is Copper -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat((60 - playerCount * 7)) { add(card.copy(supplyPlayer)) } })
            is Silver -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat(40) { add(card.copy(supplyPlayer)) } })
            is Gold -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat(30) { add(card.copy(supplyPlayer)) } })
            is Estate -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy(supplyPlayer)) } })
            is Duchy -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy(supplyPlayer)) } })
            is Province -> SupplyPile(card.copy(supplyPlayer),ArrayList<Card>().apply { repeat(if (playerCount > 2) 12 else 8) { add(card.copy(supplyPlayer)) } })
            is Cellar -> SupplyPile(card, ArrayList<Card>().apply { repeat(10) { add(card.copy()) } })
            else -> throw Exception("Card pile creation of $card not specified")
        }
    }
}