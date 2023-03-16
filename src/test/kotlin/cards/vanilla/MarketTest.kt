package cards.vanilla

import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MarketTest {
    val player = DataSource().getPlayer()
    val card = Market(player)

    @Test
    fun getCost() {
        assertThat(card.cost).isEqualTo(5)
    }

    @Test
    fun execute() {
        card.execute()
        assertThat(player.buys).isEqualTo(1)
        assertThat(player.actions).isEqualTo(1)
        assertThat(player.coins).isEqualTo(1)
    }
}