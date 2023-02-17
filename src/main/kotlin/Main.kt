import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.UsageError

class Hello: CliktCommand() {
    override fun run() {
        val input = prompt("Enter a number") {
            it.toIntOrNull() ?: throw UsageError("$it is not a valid integer")
        }
        TODO("Prompt for input, display the ggame board and state")
        if (input != null) {
            echo("Twice your number is ${input * 2}")
        }

    }
}

fun main(args: Array<String>) = Hello().main(args)

/*fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}*/






