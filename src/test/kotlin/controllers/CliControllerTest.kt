package controllers

import commands.NextPhase
import commands.NullCommand
import commands.PlayCard
import commands.Surrender
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CliControllerTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val controller: CliController = CliController()

    val actionCardZero = dataSource.getActionCard(player, 0)
    val actionCardOne = dataSource.getActionCard(player, 1)
    val treasureCardZero = dataSource.getTreasureCard(player, 0)
    val treasureCardOne = dataSource.getTreasureCard(player, 1)

    @Test
    fun run() {
    }

    @Test
    fun getCommandFrom() {
    }

    @Nested
    inner class InputToPlayerCommand {
        @Test
        fun surrender() {
            val command = controller.inputToPlayerCommand("-1", player)

            assertThat(command).isEqualTo(Surrender())
        }

        @Test
        fun nextPhase() {
            val command = controller.inputToPlayerCommand("0", player)

            assertThat(command).isEqualTo(NextPhase(player, isTurnEnd = false))
        }

        @Test
        fun `-2 is bad command`() {
            val command = controller.inputToPlayerCommand("-2", player)

            assertThat(command).isEqualTo(NullCommand())
        }

        @Test
        fun `1,1 is bad command`() {
            val command = controller.inputToPlayerCommand("1,1", player)

            assertThat(command).isEqualTo(NullCommand())
        }

        @Test
        fun `'m' is bad command`() {
            val command = controller.inputToPlayerCommand("m", player)

            assertThat(command).isEqualTo(NullCommand())
        }

        @Test
        fun `@ is bad command`() {
            val command = controller.inputToPlayerCommand("@", player)

            assertThat(command).isEqualTo(NullCommand())
        }

        @Test
        fun `'' is bad command`() {
            val command = controller.inputToPlayerCommand("", player)

            assertThat(command).isEqualTo(NullCommand())
        }

        @Test
        fun `2 and three card hand is play card`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "2",
                player = player.apply {
                    putInHand(treasureCardZero)
                    putInHand(actionCardZero)
                    putInHand(treasureCardOne)
                },
                command = PlayCard(player, actionCardZero)
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `3 and two card hand is null`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "3",
                player = player.apply {
                    putInHand(actionCardZero)
                    putInHand(actionCardOne)
                },
                command = NullCommand()
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `2 and two card hand is play card`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "2",
                player = player.apply {
                    putInHand(actionCardZero)
                    putInHand(actionCardOne)

                },
                command = PlayCard(player, actionCardOne)
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `1 and two card hand is play card`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "1",
                player = player.apply {
                    putInHand(actionCardZero)
                    putInHand(actionCardOne)

                },
                command = PlayCard(player, actionCardZero)
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `2 and one card hand is null`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "2",
                player = player.apply { putInHand(actionCardZero) },
                command = NullCommand()
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `1 and one card hand is play card`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "1",
                player = player.apply { putInHand(actionCardZero) },
                command = PlayCard(player, actionCardZero)
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }

        @Test
        fun `1 and empty hand is null`() {
            val (input, player, command) = dataSource.getInputPlayerCommandTestData(
                input = "1",
                command = NullCommand()
            )

            assertThat(controller.inputToPlayerCommand(input, player)).isEqualTo(command)
        }
    }

    @Test
    fun printStateOf() {
    }

    @Test
    fun arrayToFlatString() {
    }

    @Test
    fun arrayToCommandString() {
    }
}