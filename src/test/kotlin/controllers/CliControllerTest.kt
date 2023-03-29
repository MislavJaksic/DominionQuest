package controllers

import cards.Card
import commands.Command
import commands.TestCommand
import helpers.TestBed
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CliControllerTest {
    val testBed = TestBed()

    val controller = CliController()

    val player = testBed.getPlayer()

    val actionCardZero = testBed.getActionCard(player, 0)
    val actionCardOne = testBed.getActionCard(player, 1)
    val treasureCardZero = testBed.getTreasureCard(player, 0)
    val treasureCardOne = testBed.getTreasureCard(player, 1)

    @Test
    fun run() {
    }

    @Nested
    inner class InputToCommand {
        @Test
        fun `inputToCommand should throw UsageError if input is null`() {
            val commands = arrayListOf<Command>(TestCommand("command1"), TestCommand("command2"))
            assertThatThrownBy { controller.inputToCommand(null, commands) }.hasMessage("Input cannot be null")
        }

        @Test
        fun `inputToCommand should throw UsageError if input is not a number`() {
            val commands = arrayListOf<Command>(TestCommand("command1"), TestCommand("command2"))
            assertThatThrownBy {
                controller.inputToCommand(
                    "not a number",
                    commands
                )
            }.hasMessage("Input must be a number")
        }

        @Test
        fun `inputToCommand should throw UsageError if input number is out of range`() {
            val commands = arrayListOf<Command>(TestCommand("command1"), TestCommand("command2"))
            assertThatThrownBy { controller.inputToCommand("3", commands) }.hasMessage("Input must be between 1 and 2")
        }

        @Test
        fun `inputToCommand should return the correct command for a valid input number`() {
            val commands = arrayListOf<Command>(TestCommand("command1"), TestCommand("command2"))
            val expectedCommand = TestCommand("command1")
            assertThat(controller.inputToCommand("1", commands)).isEqualTo(expectedCommand)
        }

    }

    @Nested
    inner class InputToCards {
        @Test
        fun `inputToCards should throw UsageError if input is null`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero)
            assertThatThrownBy {
                controller.inputToCards(null, cards, 2)
            }.hasMessage("Input cannot be null")
        }

        @Test
        fun `inputToCards should throw UsageError if not enough cards are selected`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero)
            assertThatThrownBy {
                controller.inputToCards("1", cards, 2)
            }.hasMessage("Select 2 cards not 1")
        }

        @Test
        fun `inputToCards should throw UsageError if too many cards are selected`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero)
            assertThatThrownBy {
                controller.inputToCards("1 2 3 4", cards, 3)
            }.hasMessage("Select 3 cards not 4")
        }

        @Test
        fun `inputToCards should throw UsageError if input is not numbers`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero)
            assertThatThrownBy {
                controller.inputToCards("1 a", cards, 2)
            }.hasMessage("All inputs must be numbers")
        }

        @Test
        fun `inputToCards should return the correct cards for valid input`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero, treasureCardOne)
            val expectedCards = arrayListOf<Card>(actionCardZero, treasureCardZero)
            assertThat(controller.inputToCards("1 3", cards, 2)).isEqualTo(expectedCards)
        }

        @Test
        fun `inputToCards should return all cards if number is -1`() {
            val cards = arrayListOf<Card>(actionCardZero, actionCardOne, treasureCardZero, treasureCardOne)
            assertThat(controller.inputToCards("1 2 3 4", cards, -1)).isEqualTo(cards)
        }
    }
}