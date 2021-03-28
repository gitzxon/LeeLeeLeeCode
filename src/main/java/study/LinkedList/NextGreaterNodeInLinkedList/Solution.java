package study.LinkedList.NextGreaterNodeInLinkedList;

import study.list.single.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.zip.CheckedOutputStream;

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

