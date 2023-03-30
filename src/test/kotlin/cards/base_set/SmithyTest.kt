package cards.base_set

import cards.basic.Copper
import helpers.TestBed
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class SmithyTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()

    val card = Smithy(player)

    val copper = Copper(player)

    init {
        repeat(3) { player.putOnDraw(copper) }
    }

    @Nested
    inner class Execute {
        @Test
        fun `draws three cards`() {
            card.execute()

            assertThat(player.hand).isEqualTo(listOf(copper,copper, copper))
        }
    }
}