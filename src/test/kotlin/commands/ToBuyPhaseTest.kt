package commands

import helpers.TestBed
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import phases.BuyPhase

class ToBuyPhaseTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()
    val command = ToBuyPhase(player)

    @Test
    fun execute() {
        command.execute()

        assertThat(player.phase).isEqualTo(BuyPhase(player))
    }
}