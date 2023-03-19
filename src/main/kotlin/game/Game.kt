package game

import cards.ActionCard
import cards.TreasureCard
import commands.*
import controllers.Controller
import phases.ActionPhase
import phases.BuyPhase

class Game(val gameState: GameState, val controller: Controller) {
    init {
        gameState.game = this
    }

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
            val availableCommands = getAvailableCommands(player)
            val command: Command = controller.askToPickCommand(availableCommands, player, gameState.supply)

            command.execute()
            if (command is PassTurn) {
                return 0
            }
        }
    }

    fun getAvailableCommands(player: Player): ArrayList<Command> {
        val commands = ArrayList<Command>()

        commands.add(Surrender())

        if (player.phase is ActionPhase) {
            commands.add(ToBuyPhase(player))

            for (card in player.hand) {
                if (card is ActionCard) {
                    commands.add(PlayCard(player, card))
                }
            }
        } else if (player.phase is BuyPhase) {
            commands.add(PassTurn(player))

            for (card in player.hand) {
                if (card is TreasureCard) {
                    commands.add(PlayCard(player, card))
                }
            }

            for ((code, pile) in gameState.supply.supplyPiles.entries) {
                if (player.isBuy(pile.example) && gameState.supply.isCardInSupply(code)) {
                    commands.add(BuyCard(player, code))
                }
            }
        }
        return commands
    }

    override fun toString(): String {
        return "Game()"
    }
}