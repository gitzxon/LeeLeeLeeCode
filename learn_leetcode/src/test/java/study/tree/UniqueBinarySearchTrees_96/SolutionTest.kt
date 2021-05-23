package study.tree.UniqueBinarySearchTrees_96

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    @Test
    fun numTrees_1() {
        assertEquals(
            1, Solution().numTrees(1)
        )
    }

    @Test
    fun numTrees_2() {
        assertEquals(
            2, Solution().numTrees(2)
        )
    }

    @Test
    fun numTrees_3() {
        assertEquals(
            5, Solution().numTrees(3)
        )
    }

    @Test
    fun numTrees_4() {
        assertEquals(
            14, Solution().numTrees(4)
        )
    }
}