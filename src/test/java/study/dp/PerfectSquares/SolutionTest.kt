package study.dp.PerfectSquares

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun numSquares_1() {
        assertEquals(
            3, Solution().numSquares(12)
        )
    }

    @Test
    fun numSquares_2() {
        assertEquals(
            2, Solution().numSquares(13)
        )
    }
}