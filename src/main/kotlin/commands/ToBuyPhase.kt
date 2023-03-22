package commands

import game.Player
import phases.BuyPhase

data class ToBuyPhase(val player: Player) : Command {
    override fun execute() {
        player.phase = BuyPhase(player)
    }

    override fun toString(): String {
        return "ToBuyPhase()"
    }
}
