package study.AllTemplate.CoinChange

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun coinChange() {
        val ret = Solution().coinChange(
            intArrayOf(1, 2, 5),
            11
        )
        assertEquals(ret, 3)
    }

    @Test
    fun coinChange_1() {
        val ret = Solution().coinChange(
            intArrayOf(2),
            3
        )
        assertEquals(ret, -1)
    }
}