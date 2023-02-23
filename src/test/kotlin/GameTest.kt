import cards.Card
import controllers.CliController
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested

class GameTest {
    val emptyHand: ArrayList<Card> = ArrayList()
    val emptyDrawPile: ArrayList<Card> = ArrayList()
    val emptyDiscardPile: ArrayList<Card> = ArrayList()
    val emptyPlayArea: ArrayList<Card> = ArrayList()

    val player = Player("test",0, 0, 0, emptyHand, emptyDrawPile, emptyDiscardPile, emptyPlayArea)

    val playersZero: ArrayList<Player> = ArrayList()
    val playersOne: ArrayList<Player> = ArrayList<Player>().apply { this.add(player) }

    val controller = CliController()

    val gameZero = Game(playersZero, controller)
    val gameOne = Game(playersOne, controller)

    @Nested
    inner class Start {
        @Test
        fun `zero players`() {
            gameZero.start()
        }
    }


    @Test
    fun takeTurn() {
        TODO("Mock and initialize variables")
    }

}