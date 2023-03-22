package commands

import cards.Card
import cards.basic.Copper
import cards.basic.Silver
import helpers.DataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import phases.ActionPhase
import phases.BuyPhase

class PassTurnTest {
    val dataSource = DataSource()

    val player = dataSource.getPlayer()
    val command = PassTurn(player)

    val copper = Copper(player)
    val silver = Silver(player)

    init {
        player.putInHand(silver)

        repeat(5) { player.putOnDraw(copper) }
    }

    @Test
    fun execute() {
        player.phase = BuyPhase(player)
        command.execute()

        assertThat(player.phase).isEqualTo(ActionPhase(player))
        assertThat(player.coins).isEqualTo(0)
        assertThat(player.actions).isEqualTo(1)
        assertThat(player.buys).isEqualTo(1)
        assertThat(player.hand).isEqualTo(ArrayList<Card>().apply { repeat(5) { add(copper) } })
        assertThat(player.discardPile).isEqualTo(ArrayList<Card>().apply { add(silver) })
    }
}