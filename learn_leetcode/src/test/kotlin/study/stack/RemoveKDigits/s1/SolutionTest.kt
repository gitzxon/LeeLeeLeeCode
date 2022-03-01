package study.stack.RemoveKDigits.s1

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun removeKdigits() {
        assertEquals(
            "1219",
            Solution().removeKdigits(
                "1432219",
                3
            )
        )
    }

    @Test
    fun removeKdigits_1() {
        assertEquals(
            "200",
            Solution().removeKdigits(
                "10200",
                1
            )
        )
    }

    @Test
    fun removeKdigits_2() {
        assertEquals(
            "0",
            Solution().removeKdigits(
                "10",
                2
            )
        )
    }
    @Test
    fun removeKdigits_3() {
        assertEquals(
            "0",
            Solution().removeKdigits(
                "9",
                1
            )
        )
    }
}