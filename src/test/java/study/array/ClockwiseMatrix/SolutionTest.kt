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
}