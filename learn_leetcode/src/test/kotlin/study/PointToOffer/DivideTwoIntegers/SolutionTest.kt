package study.PointToOffer.DivideTwoIntegers

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun divide() {
        assertEquals(
            Int.MAX_VALUE,
            Solution().divide(
                Int.MIN_VALUE, -1
            )
        )
    }
}