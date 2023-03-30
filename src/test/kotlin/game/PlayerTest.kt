package game

import cards.Card
import helpers.TestBed
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PlayerTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()

    val actionCardZero = testBed.getActionCard(player, 0)
    val actionCardOne = testBed.getActionCard(player, 1)
    val treasureCardZero = testBed.getTreasureCard(player, 0)
    val victoryCardZero = testBed.getVictoryCard(player, 0, 0)

    val treasureCardFive = testBed.getTreasureCard(player, 5)

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
        player.gainToDiscard(actionCardZero)
        player.gainToDiscard(actionCardOne)
        assertEquals(actionCardOne, player.revealDiscard())
    }

    @Nested
    inner class Buy {
        @Test
        fun `enough coins and buys`() {
            val (player, card, expectedDiscard, expectedCoins, expectedBuys) = testBed.getBuyTestData(
                player = testBed.getPlayer(buys = 1, coins = 1),
                buyCard = actionCardOne,
                expectedDiscard = listOf(actionCardOne)
            )
            player.buy(card)

            assertThat(player.discardPile).isEqualTo(expectedDiscard)
            assertThat(player.coins).isEqualTo(expectedCoins)
            assertThat(player.buys).isEqualTo(expectedBuys)
        }
    }

    @Nested
    inner class IsBuy {
        @Test
        fun `test isBuy with buys greater than 0 and enough coins`() {
            val card = treasureCardFive
            player.buys = 1
            player.coins = 6
            assertThat(player.canBuy(card)).isTrue
        }

        @Test
        fun `test isBuy with buys greater than 0 but not enough coins`() {
            val card = treasureCardFive
            player.buys = 1
            player.coins = 4
            assertThat(player.canBuy(card)).isFalse
        }

        @Test
        fun `test isBuy with not enough buys and enough coins`() {
            val card = treasureCardFive
            player.buys = 0
            player.coins = 6
            assertThat(player.canBuy(card)).isFalse
        }

        @Test
        fun `test isBuy with not enough buys and not enough coins`() {
            val card = treasureCardFive
            player.buys = 0
            player.coins = 4
            assertThat(player.canBuy(card)).isFalse
        }
    }

    @Nested
    inner class IsAction {
        @Test
        fun `given actions is greater than 0, should return true`() {
            player.actions = 1
            assertThat(player.canPlayAction()).isTrue
        }

        @Test
        fun `given actions is 0, should return false`() {
            player.actions = 0
            assertThat(player.canPlayAction()).isFalse
        }
    }


    @Test
    fun putOnDraw() {
        player.putOnDraw(actionCardZero)
        player.putOnDraw(actionCardOne)
        player.draw(1)

        assertEquals(actionCardZero, player.drawPile[0])
        assertEquals(actionCardOne, player.hand[0])
    }

    @Nested
    inner class Draw {
        @Test
        fun `draw when both piles are empty`() {
            player.draw(1)

            assertTrue(player.hand.isEmpty())
            assertTrue(player.discardPile.isEmpty())
            assertTrue(player.drawPile.isEmpty())
        }

        @Test
        fun drawDrawPileEmpty() {
            player.gainToDiscard(actionCardZero)
            player.draw(1)

            assertEquals(actionCardZero, player.hand[0])
            assertTrue(player.discardPile.isEmpty())
            assertTrue(player.drawPile.isEmpty())
        }

        @Test
        fun drawThenShuffleThenDrawAgain() {
            player.putOnDraw(actionCardZero)
            player.gainToDiscard(actionCardOne)
            player.draw(2)

            assertEquals(actionCardZero, player.hand[0])
            assertEquals(actionCardOne, player.hand[1])
            assertTrue(player.discardPile.isEmpty())
            assertTrue(player.drawPile.isEmpty())
        }
    }

    @Test
    fun shuffleDeck() {
        player.gainToDiscard(actionCardZero)

        player.shuffleDeck()
        assertEquals(actionCardZero, player.drawPile[0])
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
            player.putInHand(actionCardZero)
            player.addActions(1)
            player.playFromHandToArea(actionCardZero)

            player.cleanup()
            assertEquals(actionCardZero, player.hand[0])
        }

        @Test
        fun `cleanup cards in hand`() {
            player.putInHand(actionCardZero)

            player.cleanup()
            assertEquals(actionCardZero, player.hand[0])
        }
    }

    @Test
    fun discard() {
        player.putInHand(treasureCardZero)

        player.discardFromHand(treasureCardZero)

        assertThat(player.discardPile).isEqualTo(listOf(treasureCardZero))
        assertThat(player.hand).isEqualTo(ArrayList<Card>())
    }
}