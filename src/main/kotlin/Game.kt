import commands.Command
import commands.NextPhase
import controllers.Controller
import supplies.Supply

class Game(val players: ArrayList<Player>, val supply: Supply, val controller: Controller) {
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
            val command: Command = controller.getCommandFrom(player, supply)

            command.execute()
            if (command is NextPhase && command.isTurnEnd) {
                return 0
            }
        }
    }
}