package cards.base_set

import cards.Card
import cards.basic.Copper
import controllers.CliController
import helpers.DataSource
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MilitiaTest {
    val controllerMock: CliController = mockk()

    val dataSource = DataSource()

    val game = dataSource.getGameState()
    val attacker = game.players[0]
    val defender = game.players[1]

    val militia = Militia(attacker)
    val copper = Copper(defender)

    init {
        defender.hand.apply { repeat(5) { add(copper) } }
        attacker.gameState.controller = controllerMock
    }

    @Nested
    inner class Execute {
        @Test
        fun `make other players discard down to three cards`() {
            val expectedHand = ArrayList<Card>().apply { repeat(3) { add(copper) } }
            every { controllerMock.askToPickCards(defender.hand, 2) } returns ArrayList<Card>().apply {
                repeat(2) {
                    add(
                        copper
                    )
                }
            }
            militia.execute()

            assertThat(attacker.coins).isEqualTo(2)
            assertThat(defender.hand).isEqualTo(expectedHand)
        }
    }
}