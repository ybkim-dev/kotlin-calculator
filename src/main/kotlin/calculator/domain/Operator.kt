package calculator.domain

import java.util.function.BiFunction

enum class Operator(
    val operator: Char,
    val operate: BiFunction<Double, Double, Double>
) {
    PLUS('+', BiFunction { num1, num2 -> num1 + num2 }),
    MINUS('-', BiFunction { num1, num2 -> num1 - num2 }),
    MULTIPLY('*', BiFunction { num1, num2 -> num1 * num2 }),
    DIVIDE('/', BiFunction { num1, num2 -> num1 / num2 });

    fun calculate(num1: Double, num2: Double) : Double {
        return operate.apply(num1, num2)
    }

    companion object {
        fun findMatchOperator(operator: Char) : Operator {
            return values().first { it.operator == operator }
        }
    }
}