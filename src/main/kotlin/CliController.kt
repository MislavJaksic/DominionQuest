import cards.basic.Copper
import cards.basic.Estate
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt

class Hello : CliktCommand() {
    val name by option().prompt()
    override fun run() {
        echo("Hello $name")
    }
}

class CliController: CliktCommand() {
    val playerA = Player(0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
    init {
        for (x: Int in 1..3) {
        playerA.drawPile.add(Estate(playerA))
        }
        for (x: Int in 1..7) {
            playerA.drawPile.add(Copper(playerA))
        }
        playerA.shuffleDeck()
        playerA.cleanup()
    }

    override fun run() {
        while (true) {
            println(playerA.toString())
            val action = prompt("What do you do?") {
                it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
            }
            if (action == -2) {
                break
            }
            actionPhase(action)

            println(playerA.toString())
            val treasure = prompt("What do you do?") {
                it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
            }
            if (action == -2) {
                break
            }
            buyPhase()
        }
    }

    fun actionPhase(action:Int?) {
        when (action) {
            (null) -> {

            }
            else -> 0/*playerA.play(playerA.hand[option])*/
        }
    }

    fun buyPhase() {
        while (true) {
            println(playerA.toString())
            val option = prompt("What do you do?") {
                it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
            }

            when (option) {
                (-2) -> {
                    break
                }
                (-1) -> {
                    actionPhase(0)
                }
                (null) -> {

                }
                else -> 0/*playerA.play(playerA.hand[option])*/
            }

        }
    }
}