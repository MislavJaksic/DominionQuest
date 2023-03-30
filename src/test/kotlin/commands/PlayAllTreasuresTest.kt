package commands

import cards.Card
import cards.basic.Silver
import helpers.TestBed
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import phases.BuyPhase

class PlayAllTreasuresTest {
    val testBed = TestBed()

    val gameState = testBed.getGameState()
    val player = gameState.players[0]

    val command = PlayAllTreasures(player)

    val smallTreasure = testBed.getTreasureCard(player)
    val smallVictory = testBed.getVictoryCard(player)

    init {
        player.phase = BuyPhase(player)
        repeat(2) {player.putInHand(smallTreasure) }
        player.putInHand(smallVictory)
    }

    @Test
    fun `put two treasure and not a victory card in play area`() {
        command.execute()

        assertThat(player.playArea).isEqualTo(listOf(smallTreasure, smallTreasure))
        assertThat(player.hand).isEqualTo(listOf(smallVictory))
    }

}