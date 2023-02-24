import controllers.Controller
import phases.ActionPhase
import phases.BuyPhase

class Game(val players: ArrayList<Player>, val controller: Controller) {
    fun start() {
        if (players.isEmpty()) {
            throw Exception("No players")
        }
        while (true) {
            for (player in players) {
                takeTurn(player)
            }
        }
    }

    fun takeTurn(player: Player): Int {
        while (true) {
            when (val input: Int = controller.getInputFrom(player)) {
                (-1) -> throw Exception("Surrender")

                (0) -> {
                    if (player.phase is ActionPhase) {
                        player.phase = BuyPhase(player)
                    } else if (player.phase is BuyPhase) {
                        player.phase = ActionPhase(player)
                        player.cleanup()
                        return 0
                    }
                }

                else -> {
                    player.play(player.hand[input - 1])
                }
            }
        }
    }
}