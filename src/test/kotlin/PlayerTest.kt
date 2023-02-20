import cards.Card
import cards.base.TestCard
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerTest {

    val emptyHand: ArrayList<Card> = ArrayList()
    val emptyDrawPile: ArrayList<Card> = ArrayList()
    val emptyDiscardPile: ArrayList<Card> = ArrayList()
    val emptyPlayArea: ArrayList<Card> = ArrayList()

    val player = Player(0, 0, 0, emptyHand, emptyDrawPile, emptyDiscardPile, emptyPlayArea)

    val testCardZero = TestCard(player, 0)
    val testCardOne = TestCard(player, 1)

    @Test
    fun play() {
    }

    @Test
    fun addActions() {
        val value = 1
        player.addActions(value)
        assertEquals(value, player.actions)
    }

    @Test
    fun addBuys() {
        val value = 1
        player.addBuys(value)
        assertEquals(value, player.buys)
    }

    @Test
    fun addCoins() {
        val value = 1
        player.addCoins(value)
        assertEquals(value, player.coins)
    }

    @Test
    fun gain() {
        player.gainToDiscard(testCardZero)
        player.gainToDiscard(testCardOne)
        assertEquals(testCardOne, player.revealTopOfDiscard())
    }

    @Test
    fun buy() {
        player.buy(testCardZero)
        player.buy(testCardOne)
        assertEquals(testCardOne, player.revealTopOfDiscard())
        assertEquals(-2, player.buys)
    }

    @Test
    fun putOnTopOfDraw() {
        player.putOnTopOfDraw(testCardZero)
        player.putOnTopOfDraw(testCardOne)
        player.draw(1)
        assertEquals(testCardZero, player.hand[0])
    }

    @Test
    fun drawBothPilesEmpty() {
        player.draw(1)
        assertEquals(emptyHand, player.hand)
        assertEquals(emptyDiscardPile, player.discardPile)
        assertEquals(emptyDrawPile, player.drawPile)
    }

    @Test
    fun drawDrawPileEmpty() {
        player.gainToDiscard(testCardZero)
        player.draw(1)
        assertEquals(testCardZero, player.hand[0])
        assertEquals(emptyDiscardPile, player.discardPile)
        assertEquals(emptyDrawPile, player.drawPile)
    }

    @Test
    fun drawThenShuffleThenDrawAgain() {
        player.putOnTopOfDraw(testCardZero)
        player.gainToDiscard(testCardOne)
        player.draw(2)
        assertEquals(testCardZero, player.hand[0])
        assertEquals(testCardOne, player.hand[1])
        assertEquals(emptyDiscardPile, player.discardPile)
        assertEquals(emptyDrawPile, player.drawPile)
    }



    @Test
    fun shuffleDeck() {
        player.gainToDiscard(testCardZero)
        player.shuffleDeck()
        assertEquals(testCardZero, player.drawPile[0])
    }

    @Test
    fun arrayToString() {
    }

    @Test
    fun testToString() {
    }




}