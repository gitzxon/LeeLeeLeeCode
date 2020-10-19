package study.dp.DungeonGame

import org.junit.Test
import java.math.BigInteger
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun calculateMinimumHP() {
        assertEquals(
            7,
            Solution().calculateMinimumHP(
                arrayOf(
                    intArrayOf(-2, -3, 3),
                    intArrayOf(-5, -10, 1),
                    intArrayOf(10, 30, -5)
                )
            )
        )
    }
}