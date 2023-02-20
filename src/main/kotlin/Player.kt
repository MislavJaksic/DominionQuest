import cards.ActionCard
import cards.Card
import cards.TreasureCard

class Player(
    var actions: Int,
    var buys: Int,
    var coins: Int,
    val hand: ArrayList<Card>,
    var drawPile: ArrayList<Card>,
    var discardPile: ArrayList<Card>,
    val playArea: ArrayList<Card>
) {

    fun play(card:Card) {
        when (card) {
            is TreasureCard -> {
                hand.remove(card)
                playArea.add(card)
                card.execute()
            }
            is ActionCard -> {
                addActions(-1)
                hand.remove(card)
                playArea.add(card)
                card.execute()
            }
            else -> {
                println("Card $card cannot be played.")
            }
        }
    }

    fun addActions(amount: Int) {
        actions += amount
    }

    fun addBuys(amount: Int) {
        buys += amount
    }

    fun addCoins(amount: Int) {
        coins += amount
    }

    fun gainToDiscard(card: Card) {
        discardPile.add(card)
    }

    fun buy(card: Card) {
        addBuys(-1)
        gainToDiscard(card)
    }

    fun putOnTopOfDraw(card:Card) {
        drawPile.add(card)
    }

    fun draw(amount: Int) {
        for (n: Int in 1..amount) {
            if (drawPile.isEmpty() and discardPile.isEmpty()) {
                break
            } else if (drawPile.isEmpty()) {
                shuffleDeck()
            }
            hand.add(drawPile.removeLast())
        }
    }

    fun revealTopOfDiscard(): Card {
        return discardPile.last()
    }

    fun shuffleDeck() {
        drawPile = discardPile.also { discardPile = drawPile }
        drawPile.shuffle()
    }

    fun arrayToString(array: ArrayList<Card>): String {
        var string = ""
        for(item in array){
            string += "\n    "
            string += item.toString()
        }
        return string
    }

    override fun toString(): String {
        return """Player(
actions=$actions
buys=$buys
coins=$coins
hand=${arrayToString(hand)}
playArea=${arrayToString(playArea)}
)"""
    }
}