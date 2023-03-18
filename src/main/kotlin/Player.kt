import cards.Card
import exceptions.BuyException
import phases.ActionPhase
import phases.Phase

class Player(
    val name: String,
    var actions: Int,
    var buys: Int,
    var coins: Int,
    val hand: ArrayList<Card>,
    val drawPile: ArrayList<Card>,
    val discardPile: ArrayList<Card>,
    val playArea: ArrayList<Card>
) {
    var phase: Phase = ActionPhase(this)

    fun addActions(amount: Int) {
        actions += amount
    }

    fun addBuys(amount: Int) {
        buys += amount
    }

    fun addCoins(amount: Int) {
        coins += amount
    }

    fun gain(card: Card) {
        card.owner = this
        discardPile.add(card)
    }

    fun buy(card: Card) {
        if (isBuy(card)) {
            addBuys(-1)
            addCoins(-card.cost)
            gain(card)
        } else {
            throw BuyException("$name player can't buy $card card because it has $buys buys and $coins coins")
        }
    }

    fun isBuy(card: Card): Boolean {
        if (buys > 0 && ((coins - card.cost) > -1)) {
            return true
        }
        return false
    }

    fun putInHand(card: Card) {
        hand.add(card)
    }

    fun putOnDraw(card: Card) {
        drawPile.add(card)
    }

    fun revealDiscard(): Card {
        return discardPile.last()
    }

    fun play(card: Card) {
        phase.play(card)
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

    fun shuffleDeck() {
        drawPile.addAll(discardPile)
        discardPile.removeAll(discardPile.toSet())
        drawPile.shuffle()
    }

    fun cleanup() {
        while (playArea.isNotEmpty()) {
            discardPile.add(playArea.removeLast())
        }
        while (hand.isNotEmpty()) {
            discardPile.add(hand.removeLast())
        }
        draw(5)
        actions = 1
        buys = 1
        coins = 0
    }

    override fun toString(): String {
        return "Player(name='$name', actions=$actions, buys=$buys, coins=$coins, hand=$hand, drawPile=$drawPile, discardPile=$discardPile, playArea=$playArea)"
    }
}