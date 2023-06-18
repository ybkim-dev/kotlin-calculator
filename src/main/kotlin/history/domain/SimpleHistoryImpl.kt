package history.domain

import history.entity.CalcResult

object SimpleHistoryImpl : History {
    private val results = mutableListOf<CalcResult>()

    override fun findAllHistory(): List<CalcResult> {
        return results.toList()
    }

    override fun saveHistory(result: CalcResult) {
        results.add(result)
    }

    override fun deleteAllHistory() {
        results.clear()
    }
}