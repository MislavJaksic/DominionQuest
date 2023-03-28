package cards.base_set

import helpers.DataSource
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MineTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val card = Mine(player)

    @Nested
    inner class Execute {
        @Test
        fun `trash Silver from hand to put Gold in hand`() {
            /*card.execute()

            Assertions.assertThat(player).isEqualTo()*/
        }
    }
}