package commands

import Player
import phases.ActionPhase
import phases.BuyPhase

data class NextPhase(val player: Player, var isTurnEnd: Boolean) : Command {
    override fun execute() {
        if (player.phase is ActionPhase) {
            player.phase = BuyPhase(player)
        } else if (player.phase is BuyPhase) {
            player.phase = ActionPhase(player)
            player.cleanup()
            isTurnEnd = true
        }
    }
}