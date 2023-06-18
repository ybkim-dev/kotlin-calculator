package history.domain

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import history.entity.CalcResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach

internal class SimpleHistoryImplTest {

    private val history = SimpleHistoryImpl

    @BeforeEach
    fun setUp() {
        history.deleteAllHistory()
    }

    @Test
    @DisplayName("계산식 결과를 저장할 수 있다.")
    fun saveTest() {
        history.saveHistory(CalcResult(UUID.randomUUID(), "1 + 2 + 3", 6.0))

        Assertions.assertThat(history.findAllHistory().size).isEqualTo(1)
    }

}