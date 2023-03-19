package commands

import cards.Card
import cards.basic.Silver
import enums.SupplyCardCode
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyCardTest {
    val dataSource = DataSource()
    val player = dataSource.getPlayer(coins = 3, buys = 1)

    val command = BuyCard(player, SupplyCardCode.SILVER)

    val code = SupplyCardCode.SILVER

    val silver = Silver(player)

    @Test
    fun execute() {
        command.execute()

        assertThat(player.coins).isEqualTo(0)
        assertThat(player.buys).isEqualTo(0)
        assertThat(player.discardPile).isEqualTo(ArrayList<Card>().apply { add(silver) })
        assertThat(player.gameState.supply.supplyPiles[code]!!.size()).isEqualTo(39)
    }

}