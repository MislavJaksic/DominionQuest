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

class WorkshopTest {
    val testBed = TestBed()
    val controllerMock: Controller = mockk()

    val gameState = testBed.getGameState()
    val game: Game = Game(gameState, controllerMock)
    val player = gameState.players[0]
    val supply = gameState.supply
    val supplyPlayer = gameState.supply.supplyPiles[0].example.owner

    val card = Workshop(player,gameState)

    init {
        gameState.game = game
    }

    @Nested
    inner class Execute {
        @Test
        fun `gain smallTreasure from supply to discard`() {
            val list = listOf(Copper(supplyPlayer), Silver(supplyPlayer), Estate(supplyPlayer))
            every { controllerMock.askToPickCards(list, 1) } returns listOf(
                Silver(player)
            )

            card.execute()

            assertThat(player.discardPile).isEqualTo(listOf(Silver(player)))
            assertThat(supply.cardToPile(Silver(player)).size()).isEqualTo(39)
        }
    }
}