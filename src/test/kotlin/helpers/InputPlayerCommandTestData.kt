package helpers

import commands.Command
import game.Player

data class InputPlayerCommandTestData(
    val input: String,
    val player: Player,
    val command: Command?
)
