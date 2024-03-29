package cards.basic

import helpers.TestBed
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ProvinceTest {
    val player = TestBed().getPlayer()
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