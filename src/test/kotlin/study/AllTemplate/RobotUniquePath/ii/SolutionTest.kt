package study.AllTemplate.RobotUniquePath.ii

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun uniquePathsWithObstacles() {
        val input = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0)
        )
        val ret = Solution().uniquePathsWithObstacles(
            input
        )

        assertEquals(2, ret)

    }
}