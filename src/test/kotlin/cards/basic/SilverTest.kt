package cards.basic

import cards.vanilla.Market
import helpers.DataSource
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SilverTest {
    val player = DataSource().getPlayer()
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