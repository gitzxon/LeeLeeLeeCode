package study.dp.MinimumPathSum

import com.sun.imageio.plugins.gif.GIFImageReader
import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {
    @Test
    fun minPathSum() {
        val grid = arrayOf(
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 1),
            intArrayOf(4, 2, 1)
        )

        val ret = Solution().minPathSum(grid)
        assertEquals(7, ret)
    }
}