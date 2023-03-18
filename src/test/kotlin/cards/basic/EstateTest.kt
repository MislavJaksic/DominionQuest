package cards.basic

import helpers.DataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class EstateTest {
    val player = DataSource().getPlayer()
    val card = Estate(player)

    @Test
    fun getPoints() {
        Assertions.assertThat(card.points).isEqualTo(1)
    }

    @Test
    fun getCost() {
        Assertions.assertThat(card.cost).isEqualTo(2)
    }
}