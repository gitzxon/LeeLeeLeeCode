package study.AllTemplate.HouseRobber.i

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun rob() {
        val ret = Solution().rob(
            intArrayOf(2, 1, 1, 2)
        )
        assertEquals(ret, 4)
    }
}