package study.dp.LastStoneWeightII

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun lastStoneWeightII_1() {
        assertEqualsExpected(
            1,
            intArrayOf(2,7,4,1,8,1)
        )
    }

    @Test
    fun lastStoneWeightII_2() {
        assertEqualsExpected(
            0,
            intArrayOf(1,1,4,2,2)

        )
    }

    @Test
    fun lastStoneWeightII_3() {
        assertEqualsExpected(
            5,
            intArrayOf( 31,26,33,21,40)
        )
    }

    fun assertEqualsExpected(
        expected: Int,
        intArray: IntArray
    ) {
        println("===== new =====")

        assertEquals(
            expected,
            Solution().lastStoneWeightII(intArray)
        )

        assertEquals(
            expected,
            Solution1().lastStoneWeightII(intArray)
        )
    }
}