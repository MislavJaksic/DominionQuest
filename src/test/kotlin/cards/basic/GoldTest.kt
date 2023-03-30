package cards.basic

import helpers.TestBed
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GoldTest {
    val player = TestBed().getPlayer()
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