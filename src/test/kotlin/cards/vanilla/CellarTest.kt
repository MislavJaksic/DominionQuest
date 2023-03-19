package cards.vanilla

import cards.Card
import cards.basic.Copper
import cards.basic.Silver
import controllers.CliController
import helpers.DataSource
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellarTest {
    val controllerMock: CliController = mockk()


    val player = DataSource().getPlayer(actions = 1)
    val copper = Copper(player)
    val silver = Silver(player)
    val card = Cellar(player)

    init {
        player.putInHand(copper)
        player.putOnDraw(silver)

        player.gameState.controller = controllerMock
    }

    @Test
    fun execute() {
        val expectedHand = ArrayList<Card>().apply { add(copper) }
        every { controllerMock.askToPickCards(player.hand, 0) } returns expectedHand
        card.execute()

        assertThat(player.hand).isEqualTo(ArrayList<Card>().apply { add(silver) })
        assertThat(player.discardPile).isEqualTo(expectedHand)
    }

    @Test
    fun getCost() {
        assertThat(card.cost).isEqualTo(2)
    }
}