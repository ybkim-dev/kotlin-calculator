package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class SimpleCalculatorTest {

    @ParameterizedTest
    @CsvSource("1 + 2 * 3, 9.0", "2 * 4 / 2, 4.0")
    @DisplayName("연산식에 따라 순차적으로 계산했을 때 올바른 연산결과가 나온다.")
    fun calculate(expression: String, answer: Double) {
        val calculator = SimpleCalculator()
        val result = calculator.calculate(expression)

        Assertions.assertThat(result).isEqualTo(answer)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 + 2 * 3"])
    @DisplayName("계산식에 대해 숫자와 연산자로 구분하여 저장할 수 있다.")
    fun split(expression: String) {
        val regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()

        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<Char>()
        val splittedExpression = expression.split(" ")
        splittedExpression.stream()
            .forEach {
                run {
                    if (regex.matches(it)) numbers.add(it.toDouble()) else operators.add(it.first())
                }
            }

        Assertions.assertThat(numbers.size - operators.size).isEqualTo(1)
    }
}