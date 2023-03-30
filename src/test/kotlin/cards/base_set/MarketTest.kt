package cards.base_set

import helpers.TestBed
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MarketTest {
    val player = TestBed().getPlayer()
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