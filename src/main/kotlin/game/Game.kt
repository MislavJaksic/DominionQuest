package game

import cards.ActionCard
import cards.Card
import cards.TreasureCard
import commands.*
import controllers.Controller
import phases.ActionPhase
import phases.BuyPhase

class Game(val gameState: GameState, val controller: Controller):Controller by controller {
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
            val command: Command = askToPickCommand(availableCommands, player, gameState.supply)

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

            commands.addAll(getPlayActionCommans(player))
        } else if (player.phase is BuyPhase) {
            commands.add(PassTurn(player))

            commands.addAll(getPlayAllTreasureCommand(player))

            commands.addAll(getPlayTreasureCommands(player))

            commands.addAll(getBuyCardCommands(player))
        }
        return commands
    }

    fun getPlayAllTreasureCommand(player: Player): ArrayList<Command> {
        val commands = ArrayList<Command>()
        for (card in player.hand) {
            if (card is TreasureCard) {
                commands.add(PlayAllTreasures(player))
                return commands
            }
        }
        return commands
    }

    fun getPlayActionCommans(player: Player): ArrayList<Command> {
        val commands = ArrayList<Command>()
        if (player.canPlayAction()) {
            for (card in player.hand) {
                if (card is ActionCard) {
                    commands.add(PlayCard(player, card))
                }
            }
        }
        return commands
    }

    fun getPlayTreasureCommands(player: Player): ArrayList<Command> {
        val commands = ArrayList<Command>()
        for (card in player.hand) {
            if (card is TreasureCard) {
                commands.add(PlayCard(player, card))
            }
        }
        return commands
    }

    fun getBuyCardCommands(player: Player): ArrayList<Command> {
        val commands = ArrayList<Command>()
        for (pile in gameState.supply.supplyPiles) {
            if (player.canBuy(pile.example) && gameState.supply.isCardSold(pile.example)) {
                commands.add(BuyCard(player, gameState, pile.example))
            }
        }
        return commands
    }

    fun playerTrashesCard(player:Player, card: Card) {
        player.trashFromHand(card)
        gameState.trash.add(card)
    }

    override fun toString(): String {
        return "Game()"
    }
}