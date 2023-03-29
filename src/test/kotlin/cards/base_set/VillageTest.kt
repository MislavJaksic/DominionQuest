package cards.base_set

import helpers.TestBed
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class VillageTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()

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