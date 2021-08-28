package study.stack.SumofSubarrayMinimums

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun sumSubarrayMins() {
        assertEquals(
            17,
            Solution().sumSubarrayMins(intArrayOf(3,1,2,4))
        )
    }
}