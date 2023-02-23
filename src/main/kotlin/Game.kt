import controllers.Controller
import phases.ActionPhase
import phases.BuyPhase
import kotlin.system.exitProcess

class Game(val players: ArrayList<Player>, val controller: Controller) {
    fun start() {
        if (players.isNotEmpty()) {
            while (true) {
                for (player in players) {
                    takeTurn(player)
                }
            }
        }
    }

    fun takeTurn(player: Player) {
        while (true) {
            val input: Int = controller.getInputFrom(player)

            when (input) {
                (-1) -> {
                    exitProcess(0)
                }
                (0) -> {
                    if (player.phase is ActionPhase) {
                        player.phase = BuyPhase(player)
                    } else if (player.phase is BuyPhase) {
                        player.phase = ActionPhase(player)
                        player.cleanup()
                        break
                    }
                } else -> {
                    player.play(player.hand[input - 1])
                }
            }
        }
    }
}