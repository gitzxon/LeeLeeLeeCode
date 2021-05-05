package study.array.NextGreaterElement

import org.junit.Test

class SolutionTest {

    @Test
    fun test() {
        Solution.nextLargerElement(longArrayOf(1, 3, 2, 4))!!.contentEquals(longArrayOf(3, 4, 4, -1))
    }

    @Test
    fun test1() {

        Solution.nextLargerElement(longArrayOf(6, 8, 0, 1, 3))!!.contentEquals(longArrayOf(8, -1, 1, 3, -1))
    }
}