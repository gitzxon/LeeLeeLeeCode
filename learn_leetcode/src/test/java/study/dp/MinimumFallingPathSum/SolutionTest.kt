package study.dp.MinimumFallingPathSum

import org.junit.Test
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun minFallingPathSum() {
        assertTrue {
            Solution().minFallingPathSum(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            ) == 12
        }

    }
}