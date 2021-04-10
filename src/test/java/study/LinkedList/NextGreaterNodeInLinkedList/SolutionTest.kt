package study.LinkedList.NextGreaterNodeInLinkedList

import org.junit.Test
import study.list.single.ListNode
import study.list.single.toLinkedList
import java.util.*
import kotlin.test.assertTrue

class SolutionTest {
    @Test
    fun nextLargerNodes() {

        val input: ListNode = intArrayOf(2, 1, 5).toLinkedList() ?: return
        val result = Solution().nextLargerNodes(input)
        println(Arrays.toString(result))
        assertTrue {
            result.toTypedArray().contentDeepEquals(arrayOf(5, 5, 0))
        }
    }


    @Test
    fun nextLargerNodes_1() {

        val input = intArrayOf(2, 7, 4, 3, 5).toLinkedList() ?: return
        val result = Solution().nextLargerNodes(input)
        println(Arrays.toString(result))
        assertTrue {
            result.toTypedArray().contentDeepEquals(arrayOf(7, 0, 5, 5, 0))
        }
    }

    @Test
    fun nextLargerNodes_2() {

        val input = intArrayOf(1, 7, 5, 1, 9, 2, 5, 1).toLinkedList() ?: return
        val result = Solution().nextLargerNodes(input)
        println(Arrays.toString(result))
        assertTrue {
            result.toTypedArray().contentDeepEquals(arrayOf(7, 9, 9, 9, 0, 5, 0, 0))
        }
    }

}