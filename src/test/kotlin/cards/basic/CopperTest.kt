package cards.basic

import helpers.DataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CopperTest {
    val player = DataSource().getPlayer()
    val card = Copper(player)

    @Test
    fun getCost() {
        Assertions.assertThat(card.cost).isEqualTo(0)
    }

    @Test
    fun execute() {
        card.execute()
        Assertions.assertThat(player.coins).isEqualTo(1)
    }
}