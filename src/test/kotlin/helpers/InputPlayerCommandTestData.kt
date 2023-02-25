package helpers

import Player
import commands.Command

data class InputPlayerCommandTestData(
    val input: String,
    val player: Player,
    val command: Command?
)
