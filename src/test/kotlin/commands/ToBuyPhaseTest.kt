package commands

import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import phases.BuyPhase

class ToBuyPhaseTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()
    val command = ToBuyPhase(player)

    @Test
    fun execute() {
        command.execute()

        assertThat(player.phase).isEqualTo(BuyPhase(player))
    }
}