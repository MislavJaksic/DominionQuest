package cards.base_set

import helpers.DataSource
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MoatTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()

    val card = Merchant(player)

    @Nested
    inner class Execute {
        @Test
        fun `description of test`() {
            /*card.execute()

            Assertions.assertThat(player).isEqualTo()*/
        }
    }
}