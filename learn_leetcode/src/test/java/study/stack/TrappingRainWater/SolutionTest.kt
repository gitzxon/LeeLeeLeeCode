package study.stack.TrappingRainWater

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun trap_1() {
        assertEquals(6, Solution().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }

    @Test
    fun trap_2() {
        assertEquals(9, Solution().trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    }
}