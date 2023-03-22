package supplies

import cards.basic.Silver
import cards.vanilla.Cellar
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SupplyTest {

    val dataSource = DataSource()

    val supply = dataSource.getSupply()

    val player = dataSource.getPlayer()

    val silver = Silver(player)
    val cellar = Cellar(player)

    @Nested
    inner class Sell {
        @Test
        fun `get card that is sold`() {
            val card = supply.sell(silver)

            assertThat(card).isEqualTo(silver)
            assertThat(supply.cardToPile(card).size()).isEqualTo(39)
        }
    }

    @Nested
    inner class IsCardSold {
        @Test
        fun `given a card that is sold, should return true`() {
            assertThat(supply.isCardInSupply(silver)).isTrue
        }

        @Test
        fun `given a card that is not sold, should return false`() {
            assertThat(supply.isCardInSupply(cellar)).isFalse
        }
    }

    @Nested
    inner class IsCardInSupply {
        @Test
        fun `given a card that is in supply, should return true`() {
            assertThat(supply.isCardInSupply(silver)).isTrue
        }

        @Test
        fun `given a card that is not in supply, should return false`() {
            assertThat(supply.isCardInSupply(cellar)).isFalse
        }
    }

    @Nested
    inner class CardToPile {
        @Test
        fun `card exists in supply`() {
            assertThat(supply.cardToPile(silver).example).isEqualTo(silver)
        }

        @Test
        fun `card does not exist in supply and should throw an exception`() {
            assertThatThrownBy { supply.cardToPile(cellar) }.hasMessage("Card pile does not exist")
        }
    }
}