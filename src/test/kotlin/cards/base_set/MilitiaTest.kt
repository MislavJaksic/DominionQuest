package cards.base_set

import cards.Card
import cards.basic.Copper
import controllers.CliController
import game.Game
import helpers.TestBed
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MilitiaTest {
    val testBed = TestBed()
    val gameMock: Game = mockk()

    val gameState = testBed.getGameState()
    val attacker = gameState.players[0]
    val defender = gameState.players[1]

    val militia = Militia(attacker, gameState)
    val copper = testBed.getTreasureCard(owner = defender)

    init {
        defender.hand.apply { repeat(5) { add(copper) } }
        gameState.game = gameMock
    }

    @Nested
    inner class Execute {
        @Test
        fun `make other players discard down to three cards`() {
            val expectedHand = ArrayList<Card>().apply { repeat(3) { add(copper) } }
            every { gameMock.askToPickCards(defender.hand, 2) } returns ArrayList<Card>().apply {
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