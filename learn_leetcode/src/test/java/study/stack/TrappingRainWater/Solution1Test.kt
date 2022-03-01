package study.stack.TrappingRainWater

import org.junit.Test
import kotlin.test.assertEquals

class Solution1Test {
    @Test
    fun trap_1() {
        assertEquals(6, Solution1().trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    }

    @Test
    fun trap_2() {
        assertEquals(9, Solution1().trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    }
}