package commands

data class CommandBundle(val basic: List<Command>, val play: List<Command>, val buy: List<Command>)
