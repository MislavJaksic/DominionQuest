import cards.ActionCard
import cards.TreasureCard

class Player() {
    var actions: Int = 1
    var buys: Int = 1
    var coins: Int = 1

    var hand: ArrayList<ActionCard> = ArrayList()

    var drawPile: ArrayList<ActionCard> = ArrayList()
    var discardPile: ArrayList<ActionCard> = ArrayList()

    fun play(actionCard: ActionCard) {
        actionCard.execute()
    }

    fun play(treasureCard: TreasureCard) {
        treasureCard.execute()
    }

    fun incrementActions() {
        actions += 1
    }

    fun incrementBuys() {
        buys += 1
    }

    fun incrementCoins() {
        coins += 1
    }

    fun draw() {
        hand.add(drawPile.removeAt(0))
    }
}