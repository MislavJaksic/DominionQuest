package cards.basic

import helpers.DataSource
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DutchyTest {
    val player = DataSource().getPlayer()
    val card = Dutchy(player)

    @Test
    fun getPoints() {
        assertThat(card.points).isEqualTo(3)
    }

    @Test
    fun getCost() {
        assertThat(card.cost).isEqualTo(5)
    }
}