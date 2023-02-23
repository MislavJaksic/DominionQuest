import cards.ActionCard
import cards.Card
import cards.TreasureCard
import phases.ActionPhase
import phases.BuyPhase
import phases.Phase

class Player(
    val name: String,
    var actions: Int,
    var buys: Int,
    var coins: Int,
    val hand: ArrayList<Card>,
    var drawPile: ArrayList<Card>,
    var discardPile: ArrayList<Card>,
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
        discardPile.add(card)
    }

    fun buy(card: Card) {
        addBuys(-1)
        gain(card)
    }

    fun putInHand(card: Card) {
        hand.add(card)
    }

    fun putOnDraw(card:Card) {
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
        drawPile = discardPile.also { discardPile = drawPile }
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
}