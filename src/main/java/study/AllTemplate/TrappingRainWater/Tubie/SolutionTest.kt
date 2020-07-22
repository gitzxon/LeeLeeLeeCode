package study.AllTemplate.TrappingRainWater.Tubie

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun trap() {
        val result = Solution().trap(
                intArrayOf(1,1,1)
        )
        assertEquals(0, result)
    }

    @Test
    fun trap_1() {
        val result = Solution().trap(
                intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
        )
        assertEquals(6, result)
    }
}