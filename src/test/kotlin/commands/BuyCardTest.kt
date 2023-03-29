package commands

import cards.Card
import cards.basic.Silver
import game.Game
import helpers.TestBed
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BuyCardTest {
    val testBed = TestBed()

    val gameState = testBed.getGameState()
    val player = gameState.players[0]

    val silver = Silver(player)

    val command = BuyCard(player, gameState, silver)

    @Test
    fun execute() {
        player.addCoins(3)
        player.addBuys(1)
        command.execute()

        assertThat(player.coins).isEqualTo(0)
        assertThat(player.buys).isEqualTo(0)
        assertThat(player.discardPile).isEqualTo(ArrayList<Card>().apply { add(silver) })
        assertThat(gameState.supply.cardToPile(silver).size()).isEqualTo(39)
    }

}