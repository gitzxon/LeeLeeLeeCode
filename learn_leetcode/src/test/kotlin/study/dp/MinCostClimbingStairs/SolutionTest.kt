package study.dp.MinCostClimbingStairs

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun minCostClimbingStairs() {
        val ret = Solution().minCostClimbingStairs(
            intArrayOf(0,1,2,0)
        )
        assertEquals(ret, 1)
    }
}