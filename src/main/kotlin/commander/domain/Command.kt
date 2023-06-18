package commander.domain

import calculator.domain.Calculator
import calculator.domain.SimpleCalculator
import history.domain.History
import history.domain.SimpleHistoryImpl
import io.domain.ConsoleIO
import io.domain.IO
import history.entity.CalcResult
import java.util.*

enum class Command(
    val command: Int,
    val history: History = SimpleHistoryImpl,
    val io: IO = ConsoleIO(),
    val calculator: Calculator = SimpleCalculator()
) : CommandExecutable {

    CALCULATE(1) {
        override fun doCommand() {
            val expression = io.getExpression()
            val calculationResult = calculator.calculate(expression)
            io.printCalculationResult(calculationResult)
            history.saveHistory(CalcResult(UUID.randomUUID(), expression, calculationResult))
        }
    },

    RETRIEVE(2) {
        override fun doCommand() {
            val histories = history.findAllHistory()
            io.printHistories(histories)
        }
    };

    companion object {
        fun getCommandType(command: Int): Command {
            return values().first { it.command == command }
        }
    }

}