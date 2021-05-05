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

//    public static class ListNode {
//        public int val;
//        public ListNode next;
//
//        public ListNode(int x) {
//            val = x;
//        }
//
//        public ListNode(int x, ListNode next) {
//            this.val = x;
//            this.next = next;
//        }
//    }
//
//    public static void main(String[] args) {
//        main2();
//    }
//
//    public static void main0() {
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//
//        System.out.println(Arrays.toString(new Solution().nextLargerNodes(node1)));
//    }
//
//    public static void main1() {
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(7);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//
//        System.out.println(Arrays.toString(new Solution().nextLargerNodes(node1)));
//
//    }
//
//    public static void main2() {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(7);
//        ListNode node3 = new ListNode(5);
//        ListNode node4 = new ListNode(1);
//        ListNode node5 = new ListNode(9);
//        ListNode node6 = new ListNode(2);
//        ListNode node7 = new ListNode(5);
//        ListNode node8 = new ListNode(1);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        System.out.println(Arrays.toString(new Solution().nextLargerNodes(node1)));
//    }

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

