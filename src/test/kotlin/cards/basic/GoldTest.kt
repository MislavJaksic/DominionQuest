package cards.basic

import helpers.DataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GoldTest {
    val player = DataSource().getPlayer()
    val card = Gold(player)

    @Test
    fun getCost() {
        Assertions.assertThat(card.cost).isEqualTo(6)
    }

    @Test
    fun execute() {
        card.execute()
        Assertions.assertThat(player.coins).isEqualTo(3)
    }
}