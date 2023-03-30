package cards.base_set

import cards.basic.Copper
import cards.basic.Estate
import cards.basic.Silver
import controllers.Controller
import game.Game
import helpers.TestBed
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class RemodelTest {
    val testBed = TestBed()
    val controllerMock: Controller = mockk()

    val gameState = testBed.getGameState()
    val game: Game = Game(gameState, controllerMock)
    val player = gameState.players[0]
    val supply = gameState.supply
    val supplyPlayer = gameState.supply.supplyPiles[0].example.owner

    val smallTreasure = testBed.getTreasureCard(owner = player)

    val card = Remodel(player,gameState)

    init {
        repeat(1) { player.putInHand(smallTreasure) }

        gameState.game = game
    }

    @Nested
    inner class Execute {
        @Test
        fun `trash smallTreasure from hand to put Estate in hand`() {
            every { controllerMock.askToPickCards(player.hand, 1) } returns listOf(smallTreasure)
            every { controllerMock.askToPickCards(listOf(Copper(supplyPlayer), Estate(supplyPlayer)), 1) } returns listOf(
                Estate(player)
            )

            card.execute()

            assertThat(player.discardPile).isEqualTo(listOf(Estate(player)))
            assertThat(supply.cardToPile(Estate(player)).size()).isEqualTo(7)
            assertThat(gameState.trash).isEqualTo(listOf(smallTreasure))
        }
    }
}