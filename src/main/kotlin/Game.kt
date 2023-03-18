import cards.basic.Copper
import cards.basic.Estate
import commands.Command
import commands.NextPhase
import controllers.Controller

class Game(val gameState: GameState, val controller: Controller) {
    fun start() {
        if (gameState.players.isEmpty()) {
            throw Exception("No players")
        }
        while (true) {
            for (player in gameState.players) {
                takeTurn(player)
            }
        }
    }

    fun takeTurn(player: Player): Int {
        while (true) {
            val command: Command = controller.getCommandFrom(player, gameState.supply)

            command.execute()
            if (command is NextPhase && command.isTurnEnd) {
                return 0
            }
        }
    }
}