package study.dp.UniquePath

import org.junit.Test
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun uniquePaths_1() {
        val ret = Solution().uniquePaths(3, 2)
        assertTrue {
            ret == 3
        }
    }

    @Test
    fun uniquePaths_2() {
        assertTrue {
            Solution().uniquePaths(3, 7) == 28
        }
    }

    @Test
    fun uniquePaths_3() {
        assertTrue {
            Solution().uniquePaths(3, 3) == 6
        }
    }
}