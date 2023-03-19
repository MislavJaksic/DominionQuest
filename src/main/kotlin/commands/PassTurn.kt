package commands

import game.Player
import phases.ActionPhase

data class PassTurn(val player: Player) : Command {
    override fun execute() {
        player.phase = ActionPhase(player)
        player.cleanup()
    }

    override fun toString(): String {
        return "PassTurn()"
    }
}
