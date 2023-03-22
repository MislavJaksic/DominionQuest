package game

import commands.Command
import commands.PassTurn
import commands.Surrender
import commands.ToBuyPhase
import controllers.CliController
import helpers.DataSource
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GameTest {
    val dataSource = DataSource()

    val controllerMock: CliController = mockk()

    val gameState = dataSource.getGameState(1)
    val onePlayerGame = Game(gameState, controllerMock)

    val supply = gameState.supply
    val player = onePlayerGame.gameState.players[0]

    val commands = ArrayList<Command>().apply { add(Surrender()) }.apply { add(ToBuyPhase(player)) }

    @Nested
    inner class Start {
        @Test
        fun `zero players`() {
            val gameState = dataSource.getGameState(0)
            val game = Game(gameState, controllerMock)
            assertThatThrownBy { game.start() }.hasMessage("No players")
        }

        @Test
        fun `one player exits`() {
            every {
                controllerMock.askToPickCommand(
                    commands,
                    player,
                    supply
                )
            } returns Surrender()
            assertThatThrownBy { onePlayerGame.start() }.hasMessage("Surrender")
        }
    }

    @Nested
    inner class TakeTurn {
        @Test
        fun surrender() {
            every {
                controllerMock.askToPickCommand(
                    commands,
                    player,
                    supply
                )
            } returns Surrender()
            assertThatThrownBy { onePlayerGame.takeTurn(player) }.hasMessage("Surrender")
        }

        @Test
        fun `end turn`() {
            every {
                controllerMock.askToPickCommand(
                    commands,
                    player,
                    supply
                )
            } returns PassTurn(player)
            assertThat(onePlayerGame.takeTurn(player)).isEqualTo(0)
        }
    }
}