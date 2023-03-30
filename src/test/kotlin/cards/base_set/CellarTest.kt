package cards.base_set

import cards.Card
import cards.basic.Silver
import game.Game
import helpers.TestBed
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellarTest {
    val testBed = TestBed()
    val gameMock: Game = mockk()
    
    val gameState = testBed.getGameState()
    val player = gameState.players[0]
    
    val smallTreasure = testBed.getTreasureCard(owner = player)
    val mediumTreasure = testBed.getTreasureCard(owner = player, cost=3)

    val card = Cellar(player, gameState)

    init {
        player.putInHand(smallTreasure)
        player.putOnDraw(mediumTreasure)

        gameState.game = gameMock
    }

    @Test
    fun execute() {
        val expectedHand = listOf(smallTreasure)
        every { gameMock.askToPickCards(player.hand, -1) } returns expectedHand
        card.execute()

        assertThat(player.hand).isEqualTo(listOf(mediumTreasure))
        assertThat(player.discardPile).isEqualTo(expectedHand)
    }

    @Test
    fun getCost() {
        assertThat(card.cost).isEqualTo(2)
    }
}