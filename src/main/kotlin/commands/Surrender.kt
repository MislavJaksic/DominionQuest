package commands

class Surrender : Command {
    override fun execute() {
        throw Exception("Surrender")
    }

}