import commands.NextPhase
import commands.Surrender
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

    val player = dataSource.getPlayer()

    val playersZero: ArrayList<Player> = ArrayList()
    val playersOne: ArrayList<Player> = ArrayList<Player>().apply { this.add(player) }

    val controllerMock: CliController = mockk()

    val supply = dataSource.getSupply()

    val gameZero = Game(playersZero, supply, controllerMock)
    val gameOne = Game(playersOne, supply, controllerMock)

    @Nested
    inner class Start {
        @Test
        fun `zero players`() {
            assertThatThrownBy { gameZero.start() }.hasMessage("No players")
        }

        @Test
        fun `one player exits`() {
            every { controllerMock.getCommandFrom(player, supply) } returns Surrender()
            assertThatThrownBy { gameOne.start() }.hasMessage("Surrender")
        }
    }

    @Nested
    inner class TakeTurn {
        @Test
        fun surrender() {
            every { controllerMock.getCommandFrom(player, supply) } returns Surrender()
            assertThatThrownBy { gameOne.takeTurn(player) }.hasMessage("Surrender")
        }

        @Test
        fun `start action phase`() {
            every { controllerMock.getCommandFrom(player, supply) } returns NextPhase(player, isTurnEnd = false)
            assertThat(gameOne.takeTurn(player)).isEqualTo(0)
        }

        @Test
        fun `pass action and buy phases`() {
            every { controllerMock.getCommandFrom(player, supply) } returns NextPhase(player, isTurnEnd = true)
            assertThat(gameOne.takeTurn(player)).isEqualTo(0)
        }
    }
}