package commands

import cards.Card
import cards.basic.Copper
import cards.basic.Silver
import helpers.TestBed
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import phases.ActionPhase
import phases.BuyPhase

class PassTurnTest {
    val testBed = TestBed()

    val player = testBed.getPlayer()
    val command = PassTurn(player)

    val smallTreasure = testBed.getTreasureCard(owner = player)
    val mediumTreasure = testBed.getTreasureCard(owner = player, cost=3)

    init {
        player.putInHand(mediumTreasure)

        repeat(5) { player.putOnDraw(smallTreasure) }
    }

    @Test
    fun execute() {
        player.phase = BuyPhase(player)
        command.execute()

        assertThat(player.phase).isEqualTo(ActionPhase(player))
        assertThat(player.coins).isEqualTo(0)
        assertThat(player.actions).isEqualTo(1)
        assertThat(player.buys).isEqualTo(1)
        assertThat(player.hand).isEqualTo(ArrayList<Card>().apply { repeat(5) { add(smallTreasure) } })
        assertThat(player.discardPile).isEqualTo(listOf(mediumTreasure))
    }
}