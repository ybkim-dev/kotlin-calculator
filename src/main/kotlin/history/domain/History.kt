package history.domain

import history.entity.CalcResult

interface History {
    fun findAllHistory(): List<CalcResult>
    fun saveHistory(result: CalcResult)
    fun deleteAllHistory()
}