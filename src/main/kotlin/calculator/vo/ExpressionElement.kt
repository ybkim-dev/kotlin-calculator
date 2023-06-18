package calculator.vo

data class ExpressionElement(
    val operators: List<Char>,
    val numbers: List<Double>
)