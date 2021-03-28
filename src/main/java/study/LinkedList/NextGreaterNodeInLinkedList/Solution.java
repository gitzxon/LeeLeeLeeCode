package study.LinkedList.NextGreaterNodeInLinkedList;

import study.list.single.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * prev larger nodes 比较简单。
 * 只需要从左往右遍历，利用栈存一下扫过的值。并且，让栈一直是**上小下大**
 *
 * 所以，next larger nodes，就从右往左走就行了。
 * 但是，链表右往左，不能遍历。所以，想到可以 revert 一下。
 *
 */
public class Solution {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        if (head.next == null) {
            return new int[1];
        }

        ListNode revert = revert(head);
        int count = count(revert);
        int[] result = new int[count];
        int curIndex = count - 1;
        ListNode curNode = revert;
        Deque<Integer> stack = new LinkedList<>();


        while (curNode != null) {
            while (stack.size() != 0 && stack.peekLast() <= curNode.val) {
                stack.pollLast();
            }
            if (stack.size() == 0) {
                result[curIndex] = 0;
            } else {
                result[curIndex] = stack.peekLast();
            }
            stack.offerLast(curNode.val);

            curNode = curNode.next;
            curIndex--;
        }

        return result;
    }

    private int count(ListNode head) {
        if (head == null) {
            return 0;
        }

        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        return count;
    }

    private ListNode revert(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode cur = pre.next;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        dummy.next.next = null;
        return pre;
    }
}

