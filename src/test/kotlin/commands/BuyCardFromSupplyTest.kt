package commands

import cards.Card
import cards.basic.Silver
import enums.SupplyCardCode
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import phases.ActionPhase
import phases.BuyPhase
import supplies.SupplyPile

class BuyCardFromSupplyTest {
    val dataSource = DataSource()
    val player = dataSource.getPlayer(coins = 3, buys = 1)
    val supply = dataSource.getSupply()

    val code = SupplyCardCode.SILVER

    init {
        player.phase = BuyPhase(player)
    }

    @Nested
    inner class Execute {
        @Test
        fun `code not in supply`() {
            val code = SupplyCardCode.FIRST
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(ArrayList<Card>())
        }

        @Test
        fun `not buy phase`() {
            player.phase = ActionPhase(player)
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(ArrayList<Card>())
        }

        @Test
        fun `player can't buy card`() {
            val code = SupplyCardCode.DUCHY
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(ArrayList<Card>())
        }

        @Test
        fun `card not in supply`() {
            supply.supplyPiles[code] = SupplyPile(Silver(player), ArrayList<Card>())
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(ArrayList<Card>())
            assertThat(supply.supplyPiles[code]!!.size()).isEqualTo(0)
        }

        @Test
        fun `buy silver`() {
            val cardDiscard = ArrayList<Card>().apply { add(Silver(player)) }
            val command = BuyCardFromSupply(player, code, supply)

            command.execute()

            assertThat(player.discardPile).isEqualTo(cardDiscard)
            assertThat(supply.supplyPiles[code]!!.size()).isEqualTo(39)
        }
    }

}