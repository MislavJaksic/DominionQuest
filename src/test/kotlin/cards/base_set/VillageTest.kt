package cards.base_set

import cards.basic.Copper
import helpers.TestBed
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class VillageTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()

    val card = Village(player)

    val copper = Copper(player)

    init {
        repeat(1) { player.putOnDraw(copper) }
    }

    @Nested
    inner class Execute {
        @Test
        fun `draws two cards`() {
            card.execute()

            assertThat(player.actions).isEqualTo(2)
            assertThat(player.hand).isEqualTo(listOf(copper))
        }
    }
}