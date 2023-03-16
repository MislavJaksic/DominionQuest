package cards.basic

import helpers.DataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProvinceTest {
    val player = DataSource().getPlayer()
    val card = Province(player)

    @Test
    fun getPoints() {
        Assertions.assertThat(card.points).isEqualTo(6)
    }

    @Test
    fun getCost() {
        Assertions.assertThat(card.cost).isEqualTo(8)
    }
}