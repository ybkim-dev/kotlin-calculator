package commander.domain

import calculator.domain.Calculator
import calculator.domain.SimpleCalculator
import history.domain.History
import history.domain.SimpleHistoryImpl
import history.entity.CalcResult
import io.domain.ConsoleIO
import io.domain.IO
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.*

internal class CommanderTest {

    private val io: IO = ConsoleIO()
    private val history: History = SimpleHistoryImpl
    private val calculator: Calculator = SimpleCalculator()

    @BeforeEach
    fun setUp() {
        history.deleteAllHistory()
    }

    @ParameterizedTest
    @CsvSource("1 + 2 + 3, 6")
    @DisplayName("계산 결과를 출력하고 저장한다.")
    fun printCalcResultAndSave(expression: String, calculationResult: Double) {

        calculator.calculate(expression)
        io.printCalculationResult(calculationResult)
        history.saveHistory(CalcResult(UUID.randomUUID(), expression, calculationResult))

        Assertions.assertThat(history.findAllHistory().size).isEqualTo(1)
    }
}