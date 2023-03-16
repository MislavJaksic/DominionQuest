package commands

import cards.Card
import cards.basic.Silver
import enums.SupplyCardCode
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Nested
import phases.BuyPhase

class BuyCardFromSupplyTest {
    val dataSource = DataSource()
    val player = dataSource.getPlayer(coins = 3, buys = 1)
    val supply = dataSource.getSupply()

    @Nested
    inner class Execute {
        @Test
        fun `code not in supply`() {

        }

        @Test
        fun `not buy phase`() {
        }

        @Test
        fun `player can't buy card`() {
        }

        @Test
        fun `card not in supply`() {
        }

        @Test
        fun `buy silver`() {
            player.phase = BuyPhase(player)
            val code = SupplyCardCode.SILVER
            val cardDiscard = ArrayList<Card>().apply{add(Silver(player))}
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(cardDiscard)
            assertThat(supply.supplyPiles[code]!!.size()).isEqualTo(39)
        }

        @Test
        fun `buy dutchy`() {
        }
    }

}