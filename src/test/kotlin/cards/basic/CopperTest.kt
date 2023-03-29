package cards.basic

import helpers.TestBed
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CopperTest {
    val player = TestBed().getPlayer()
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