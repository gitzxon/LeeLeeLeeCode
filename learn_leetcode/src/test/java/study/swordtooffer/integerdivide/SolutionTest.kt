package study.swordtooffer.integerdivide

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun divide() {
        assertEquals(
            Integer.MAX_VALUE,
            Solution().divide(Integer.MIN_VALUE, -1)
        )
    }
}