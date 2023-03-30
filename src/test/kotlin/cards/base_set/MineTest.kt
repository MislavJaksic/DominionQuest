package cards.base_set

import cards.Card
import cards.basic.Copper
import cards.basic.Silver
import controllers.CliController
import controllers.Controller
import game.Game
import helpers.TestBed
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MineTest {
    val testBed = TestBed()
    val controllerMock: Controller = mockk()

    val gameState = testBed.getGameState()
    val game: Game = Game(gameState, controllerMock)
    val player = gameState.players[0]
    val supply = gameState.supply
    val supplyPlayer = gameState.supply.supplyPiles[0].example.owner

    val smallTreasure = testBed.getTreasureCard(owner = player)

    val card = Mine(player,gameState)

    init {
        repeat(1) { player.putInHand(smallTreasure) }

        gameState.game = game
    }

    @Nested
    inner class Execute {
        @Test
        fun `trash smallTreasure from hand to put Silver in hand`() {
            every { controllerMock.askToPickCards(player.hand, 1) } returns listOf(smallTreasure)
            every { controllerMock.askToPickCards(listOf(Copper(supplyPlayer),Silver(supplyPlayer)), 1) } returns listOf(Silver(player))

            card.execute()

            assertThat(player.discardPile).isEqualTo(listOf(Silver(player)))
            assertThat(supply.cardToPile(Silver(player)).size()).isEqualTo(39)
            assertThat(gameState.trash).isEqualTo(listOf(smallTreasure))
        }
    }
}