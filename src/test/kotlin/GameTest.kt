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

    val gameZero = Game(playersZero, controllerMock)
    val gameOne = Game(playersOne, controllerMock)

    @Nested
    inner class Start {
        @Test
        fun `zero players`() {
            assertThatThrownBy { gameZero.start() }.hasMessage("No players")
        }

        @Test
        fun `one player exits`() {
            every { controllerMock.getInputFrom(player) } returns -1
            assertThatThrownBy { gameOne.start() }.hasMessage("Surrender")
        }
    }

    @Nested
    inner class TakeTurn {
        @Test
        fun surrender() {
            every { controllerMock.getInputFrom(player) } returns -1
            assertThatThrownBy { gameOne.takeTurn(player) }.hasMessage("Surrender")
        }

        @Test
        fun `pass action and buy phases`() {
            every { controllerMock.getInputFrom(player) } returns 0
            assertThat(gameOne.takeTurn(player)).isEqualTo(0)
        }
    }
}