package game

import cards.Card
import helpers.DataSource
import helpers.PlayTestData
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Named.named
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import phases.BuyPhase
import java.util.stream.Stream

class PlayerTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val actionCardZero = dataSource.getActionCard(player, 0)
    val actionCardOne = dataSource.getActionCard(player, 1)
    val treasureCardZero = dataSource.getTreasureCard(player, 0)
    val victoryCardZero = dataSource.getVictoryCard(player, 0, 0)

    val treasureCardFive = dataSource.getTreasureCard(player, 5)

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    inner class Play { /* code was not shortened with parameterized tests */
        fun playTestDataProvider() = Stream.of(
            arguments(
                named(
                    "play action without actions in action phase",
                    dataSource.getPlayTestData(
                        playCard = actionCardZero,
                        expectedHand = ArrayList<Card>().apply { add(actionCardZero) }
                    )
                )
            ),
            arguments(dataSource.getPlayTestData(
                player = dataSource.getPlayer(actions = 1),
                playCard = actionCardZero,
                expectedPlayArea = ArrayList<Card>().apply { add(actionCardZero) }
            )),
            arguments(
                dataSource.getPlayTestData(
                    playCard = treasureCardZero,
                    expectedHand = ArrayList<Card>().apply { add(treasureCardZero) },
                )
            ),
            arguments(
                dataSource.getPlayTestData(
                    playCard = victoryCardZero,
                    expectedHand = ArrayList<Card>().apply { add(victoryCardZero) },
                )
            ),
            arguments(
                dataSource.getPlayTestData(
                    player = dataSource.getPlayer().apply { this.phase = BuyPhase(this) },
                    playCard = actionCardZero,
                    expectedHand = ArrayList<Card>().apply { add(actionCardZero) },
                )
            ),
            arguments(
                dataSource.getPlayTestData(
                    player = dataSource.getPlayer(actions = 1).apply { this.phase = BuyPhase(this) },
                    playCard = actionCardZero,
                    expectedHand = ArrayList<Card>().apply { add(actionCardZero) },
                )
            ),
            arguments(dataSource.getPlayTestData(
                player = dataSource.getPlayer().apply { this.phase = BuyPhase(this) },
                playCard = treasureCardZero,
                expectedPlayArea = ArrayList<Card>().apply { add(treasureCardZero) }
            )),
            arguments(
                dataSource.getPlayTestData(
                    player = dataSource.getPlayer().apply { this.phase = BuyPhase(this) },
                    playCard = victoryCardZero,
                    expectedHand = ArrayList<Card>().apply { add(victoryCardZero) },
                )
            )
        )

        @ParameterizedTest
        @MethodSource("playTestDataProvider")
        fun playActionPhase(playTestData: PlayTestData) {
            val (player, card, expectedHand, expectedPlayArea) = playTestData
            player.putInHand(card)
            player.play(card)

            assertThat(player.hand).isEqualTo(expectedHand)
            assertThat(player.playArea).isEqualTo(expectedPlayArea)
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
        player.gain(actionCardZero)
        player.gain(actionCardOne)
        assertEquals(actionCardOne, player.revealDiscard())
    }

    @Nested
    inner class Buy {
        @Test
        fun `enough coins and buys`() {
            val (player, card, expectedDiscard, expectedCoins, expectedBuys) = dataSource.getBuyTestData(
                player = dataSource.getPlayer(buys = 1, coins = 1),
                buyCard = actionCardOne,
                expectedDiscard = ArrayList<Card>().apply { add(actionCardOne) }
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
            assertThat(player.isBuy(card)).isTrue
        }

        @Test
        fun `test isBuy with buys greater than 0 but not enough coins`() {
            val card = treasureCardFive
            player.buys = 1
            player.coins = 4
            assertThat(player.isBuy(card)).isFalse
        }

        @Test
        fun `test isBuy with not enough buys and enough coins`() {
            val card = treasureCardFive
            player.buys = 0
            player.coins = 6
            assertThat(player.isBuy(card)).isFalse
        }

        @Test
        fun `test isBuy with not enough buys and not enough coins`() {
            val card = treasureCardFive
            player.buys = 0
            player.coins = 4
            assertThat(player.isBuy(card)).isFalse
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
            player.gain(actionCardZero)
            player.draw(1)

            assertEquals(actionCardZero, player.hand[0])
            assertTrue(player.discardPile.isEmpty())
            assertTrue(player.drawPile.isEmpty())
        }

        @Test
        fun drawThenShuffleThenDrawAgain() {
            player.putOnDraw(actionCardZero)
            player.gain(actionCardOne)
            player.draw(2)

            assertEquals(actionCardZero, player.hand[0])
            assertEquals(actionCardOne, player.hand[1])
            assertTrue(player.discardPile.isEmpty())
            assertTrue(player.drawPile.isEmpty())
        }
    }

    @Test
    fun shuffleDeck() {
        player.gain(actionCardZero)

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
            player.play(actionCardZero)

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

        player.discard(treasureCardZero)

        assertThat(player.discardPile).isEqualTo(ArrayList<Card>().apply { add(treasureCardZero) })
        assertThat(player.hand).isEqualTo(ArrayList<Card>())
    }
}