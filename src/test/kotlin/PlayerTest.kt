import cards.Card
import cards.test.TestActionCard
import cards.test.TestTreasureCard
import cards.test.TestVictoryCard
import controllers.CliController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import phases.ActionPhase
import phases.BuyPhase

class PlayerTest {

    val emptyHand: ArrayList<Card> = ArrayList()
    val emptyDrawPile: ArrayList<Card> = ArrayList()
    val emptyDiscardPile: ArrayList<Card> = ArrayList()
    val emptyPlayArea: ArrayList<Card> = ArrayList()

    val player = Player("test",0, 0, 0, emptyHand, emptyDrawPile, emptyDiscardPile, emptyPlayArea)

    val players: ArrayList<Player> = ArrayList()

    val controller = CliController()

    val game = Game(players, controller)

    val testActionCardZero = TestActionCard(player, 0)
    val testActionCardOne = TestActionCard(player, 1)
    val testTreasureCardZero = TestTreasureCard(player, 0)
    val testVictoryCardZero = TestVictoryCard(player, 0,0)

    @Nested
    inner class Play {
        @Test
        fun `play action in action phase`() {
            player.addActions(1)
            player.putInHand(testActionCardZero)
            player.play(testActionCardZero)

            assertEquals(true, player.hand.isEmpty())
            assertEquals(testActionCardZero, player.playArea[0])
        }

        @Test
        fun `play treasure in action phase`() {
            player.putInHand(testTreasureCardZero)
            player.play(testTreasureCardZero)

            assertEquals(testTreasureCardZero, player.hand[0])
            assertEquals(true, player.playArea.isEmpty())
        }

        @Test
        fun `play victory in action phase`() {
            player.putInHand(testVictoryCardZero)
            player.play(testVictoryCardZero)

            assertEquals(testVictoryCardZero, player.hand[0])
            assertEquals(true, player.playArea.isEmpty())
        }

        @Test
        fun `play action in buy phase`() {
            player.phase = BuyPhase(player)
            player.addActions(1)
            player.putInHand(testActionCardZero)
            player.play(testActionCardZero)

            assertEquals(testActionCardZero, player.hand[0])
            assertEquals(true, player.playArea.isEmpty())
        }

        @Test
        fun `play treasure in buy phase`() {
            player.phase = BuyPhase(player)
            player.putInHand(testTreasureCardZero)
            player.play(testTreasureCardZero)

            assertEquals(true, player.hand.isEmpty())
            assertEquals(testTreasureCardZero, player.playArea[0])
        }

        @Test
        fun `play victory in buy phase`() {
            player.phase = BuyPhase(player)
            player.putInHand(testVictoryCardZero)
            player.play(testVictoryCardZero)

            assertEquals(testVictoryCardZero, player.hand[0])
            assertEquals(true, player.playArea.isEmpty())
        }
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
        player.gain(testActionCardZero)
        player.gain(testActionCardOne)
        assertEquals(testActionCardOne, player.revealDiscard())
    }

    @Test
    fun buy() {
        player.buy(testActionCardZero)
        player.buy(testActionCardOne)
        assertEquals(testActionCardOne, player.revealDiscard())
        assertEquals(-2, player.buys)
    }

    @Test
    fun putOnDraw() {
        player.putOnDraw(testActionCardZero)
        player.putOnDraw(testActionCardOne)
        player.draw(1)

        assertEquals(testActionCardZero, player.drawPile[0])
        assertEquals(testActionCardOne, player.hand[0])
    }
    @Nested
    inner class Draw {
        @Test
        fun `draw when both piles are empty`() {
            player.draw(1)

            assertEquals(emptyHand, player.hand)
            assertEquals(emptyDiscardPile, player.discardPile)
            assertEquals(emptyDrawPile, player.drawPile)
        }

        @Test
        fun drawDrawPileEmpty() {
            player.gain(testActionCardZero)
            player.draw(1)

            assertEquals(testActionCardZero, player.hand[0])
            assertEquals(emptyDiscardPile, player.discardPile)
            assertEquals(emptyDrawPile, player.drawPile)
        }

        @Test
        fun drawThenShuffleThenDrawAgain() {
            player.putOnDraw(testActionCardZero)
            player.gain(testActionCardOne)
            player.draw(2)

            assertEquals(testActionCardZero, player.hand[0])
            assertEquals(testActionCardOne, player.hand[1])
            assertEquals(emptyDiscardPile, player.discardPile)
            assertEquals(emptyDrawPile, player.drawPile)
        }
    }

    @Test
    fun shuffleDeck() {
        player.gain(testActionCardZero)

        player.shuffleDeck()
        assertEquals(testActionCardZero, player.drawPile[0])
    }

    @Nested
    inner class Cleanup {
        @Test
        fun `cleanup actions, coins, buys`() {
            player.cleanup()
            assertEquals(1, player.buys)
            assertEquals(1, player.actions)
            assertEquals(0, player.coins)
        }
        @Test
        fun `cleanup played cards`() {
            player.putInHand(testActionCardZero)
            player.addActions(1)
            player.play(testActionCardZero)

            player.cleanup()
            assertEquals(testActionCardZero, player.hand[0])
        }

        @Test
        fun `cleanup cards in hand`() {
            player.putInHand(testActionCardZero)

            player.cleanup()
            assertEquals(testActionCardZero, player.hand[0])
        }
    }
}