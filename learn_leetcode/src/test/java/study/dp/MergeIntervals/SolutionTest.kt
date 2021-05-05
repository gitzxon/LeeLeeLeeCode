package study.dp.MergeIntervals

import org.junit.Test

class SolutionTest {
    @Test
    fun merge_1() {

        val result = Solution().merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        )


        println("result = ${result.contentDeepToString()}")
    }

    @Test
    fun merge_2() {

        val result = Solution().merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        )

        println("result = ${result.contentDeepToString()}")
    }
}