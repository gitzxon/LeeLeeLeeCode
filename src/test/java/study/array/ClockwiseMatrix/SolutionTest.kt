package study.array.ClockwiseMatrix

import org.junit.Test

class SolutionTest {
    @Test
    fun spiralOrder() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val ret = SolutionSucks().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }

    @Test
    fun spiralOrder_1() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val ret = SolutionSucks().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }

    @Test
    fun spiralOrder_2() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3)
        )
        val ret = Solution().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }

    @Test
    fun spiralOrder_3() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(4),
            intArrayOf(7)
        )
        val ret = Solution().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }

    @Test
    fun spiralOrder_4() {
        val matrix = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6)
        )
        val ret = Solution().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }

    @Test
    fun spiralOrder_5() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
            intArrayOf(10, 11, 12)
        )
        val ret = Solution().spiralOrder(matrix)
        println("ret.joinToString() = ${ret.joinToString()}")
    }
}