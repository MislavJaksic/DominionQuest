package cards.basic

import helpers.TestBed
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SilverTest {
    val player = TestBed().getPlayer()
    val card = Silver(player)

    @Test
    fun getCost() {
        Assertions.assertThat(card.cost).isEqualTo(3)
    }

    @Test
    fun execute() {
        card.execute()
        Assertions.assertThat(player.coins).isEqualTo(2)
    }
}