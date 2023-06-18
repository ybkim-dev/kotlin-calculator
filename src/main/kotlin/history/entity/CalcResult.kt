package history.entity

import java.util.UUID

data class CalcResult(
    val uuid: UUID,
    val expression: String,
    val answer: Double
)