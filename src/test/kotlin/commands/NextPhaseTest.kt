package commands

import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import phases.ActionPhase
import phases.BuyPhase

class NextPhaseTest {

    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val nextPhase = dataSource.getNextPhase(player)

    @Nested
    inner class Execute {
        @Test
        fun initial() {
            assertThat(nextPhase.isTurnEnd).isFalse
            assertThat(player.phase).isEqualTo(ActionPhase(player))
        }

        @Test
        fun `execute next phase once`() {
            nextPhase.execute()

            assertThat(nextPhase.isTurnEnd).isFalse
            assertThat(player.phase).isEqualTo(BuyPhase(player))
        }

        @Test
        fun `execute next phase twice`() {
            nextPhase.execute()
            nextPhase.execute()

            assertThat(nextPhase.isTurnEnd).isTrue
            assertThat(player.phase).isEqualTo(ActionPhase(player))
        }
    }
}