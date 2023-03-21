package commands

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SurrenderTest {

    val command = Surrender()

    @Test
    fun execute() {
        Assertions.assertThatThrownBy { command.execute() }.hasMessage("Surrender")
    }
}