package study.dp.MinimumCostForTickets

import org.junit.Test
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun mincostTickets_1() {
        assertTrue {
            Solution().mincostTickets(
                intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31),
                intArrayOf(2, 7, 15)
            ) == 17
        }

    }

    @Test
    fun mincostTickets_2() {
        assertTrue {
            Solution().mincostTickets(
                intArrayOf(1, 4, 6, 7, 8, 20),
                intArrayOf(2, 7, 15)
            ) == 11
        }
    }


    @Test
    fun mincostTickets_3() {
        assertTrue {
            Solution().mincostTickets(
                intArrayOf(1, 2, 3),
                intArrayOf(2, 7, 15)
            ) == 6
        }
    }

    @Test
    fun mincostTickets_4() {
        assertTrue {
            Solution().mincostTickets(
                intArrayOf(1, 2, 3, 4, 5, 6, 7),
                intArrayOf(2, 7, 15)
            ) == 7
        }
    }

    @Test
    fun mincostTickets_5() {
        assertTrue {
            Solution().mincostTickets(
                intArrayOf(1),
                intArrayOf(2, 7, 15)
            ) == 2
        }
    }
}