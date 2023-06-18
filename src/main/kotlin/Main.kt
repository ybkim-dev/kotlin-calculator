import commander.domain.Commander
import io.domain.ConsoleIO

fun main() {
    val commander: Commander = Commander(ConsoleIO())
    commander.command()
}