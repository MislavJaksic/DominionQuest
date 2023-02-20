import cards.base.Copper
import cards.base.Estate
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

class Game: CliktCommand() {
    val playerA = Player(0, 0, 0, ArrayList(), ArrayList(), ArrayList(), ArrayList())
    init {
        for (x: Int in 1..3) {
        playerA.drawPile.add(Estate(playerA))
        }
        for (x: Int in 1..7) {
            playerA.drawPile.add(Copper(playerA))
        }
        playerA.shuffleDeck()
        playerA.draw(5)
    }

    override fun run() {
        while (true) {
            val option = prompt(playerA.toString()) {
                /*option().choice("1", "2")*/
                it.toIntOrNull() ?: throw UsageError("$it is not a valid option")
            }
            if (option != null) {
                playerA.play(playerA.hand[option])
            }
        }
    }
}