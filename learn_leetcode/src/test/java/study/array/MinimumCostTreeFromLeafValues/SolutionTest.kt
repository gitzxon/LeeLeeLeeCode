package study.array.MinimumCostTreeFromLeafValues

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun mctFromLeafValues() {
        assertEquals(
            32,
            Solution().mctFromLeafValues(intArrayOf(6, 2, 4))
        )
    }
}