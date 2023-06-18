package calculator.domain

import calculator.vo.ExpressionElement

class SimpleCalculator : Calculator {

    private val regex: Regex = "-?[0-9]+(\\.[0-9]+)?".toRegex()

    override fun calculate(expression: String): Double {
        val expressionElement = split(expression)
        val numbers = expressionElement.numbers.toList()
        val operators = expressionElement.operators.toList()

        var calculationResult: Double = numbers[0]
        for (i in operators.indices) {
            val operator = Operator.findMatchOperator(operators[i])
            calculationResult = operator.calculate(calculationResult, numbers[i + 1])
        }
        return calculationResult
    }

    private fun split(expression: String): ExpressionElement {
        val numbers = mutableListOf<Double>()
        val operators = mutableListOf<Char>()
        val splittedExpression = expression.split(" ")
        splittedExpression.stream()
            .forEach {
                run {
                    if (regex.matches(it)) numbers.add(it.toDouble()) else operators.add(it.first())
                }
            }
        return ExpressionElement(operators, numbers)
    }
}