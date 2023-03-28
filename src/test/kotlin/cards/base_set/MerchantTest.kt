package cards.base_set

import cards.Card
import cards.basic.Copper
import cards.basic.Silver
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MerchantTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer(actions = 1)

    val card = Merchant(player)
    val copper = Copper(player)
    val silver = Silver(player)

    init {
        player.putOnDraw(copper)
    }

    @Nested
    inner class Execute {
        @Test
        fun `add action, draw card without playing silver`() {
            player.play(card)

            assertThat(player.actions).isEqualTo(1)
            assertThat(player.coins).isEqualTo(0)
            assertThat(player.hand).isEqualTo(ArrayList<Card>().apply { add(copper) })
            assertThat(player.isPlayedSilver).isFalse
        }

        @Test
        fun `play Merchant, then Silver then, add coins`() {
            player.play(card)
            silver.execute()

            assertThat(player.actions).isEqualTo(1)
            assertThat(player.coins).isEqualTo(3)
            assertThat(player.isPlayedSilver).isTrue
        }

        @Test
        fun `play Silver, then Merchant, then add coins`() {
            silver.execute()
            player.play(card)

            assertThat(player.actions).isEqualTo(1)
            assertThat(player.coins).isEqualTo(3)
            assertThat(player.isPlayedSilver).isTrue
        }

    }
}