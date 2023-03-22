package commands

import cards.Card
import cards.basic.Silver
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyCardTest {
    val dataSource = DataSource()
    val player = dataSource.getPlayer(coins = 3, buys = 1)

    val silver = Silver(player)

    val command = BuyCard(player, silver)

    @Test
    fun execute() {
        command.execute()

        assertThat(player.coins).isEqualTo(0)
        assertThat(player.buys).isEqualTo(0)
        assertThat(player.discardPile).isEqualTo(ArrayList<Card>().apply { add(silver) })
        assertThat(player.gameState.supply.cardToPile(silver).size()).isEqualTo(39)
    }

}