package study.array.SubArrayRanges

import org.junit.Test

class SolutionTest {
    @Test
    fun subArrayRanges() {
        val inputArray = intArrayOf(1,2,3)
        assert(Solution().subArrayRanges(inputArray) == 4L)
    }

    @Test
    fun subArrayRanges_1() {
        val inputArray = intArrayOf(1,3,3)
        val expected = 4
        assert(Solution().subArrayRanges(inputArray) == expected.toLong())
    }

    @Test
    fun subArrayRanges_2() {
        val inputArray = intArrayOf(4,-2,-3,4,1)
        val expected = 59
        assert(Solution().subArrayRanges(inputArray) == expected.toLong())
    }
}