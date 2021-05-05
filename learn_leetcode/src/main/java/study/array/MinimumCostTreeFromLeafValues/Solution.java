package study.array.MinimumCostTreeFromLeafValues;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int mctFromLeafValues(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }

        if (arr.length == 2) {
            return arr[0] * arr[1];
        }

        Deque<Integer> stack = new LinkedList<>();
        stack.push(Integer.MAX_VALUE);
        int result = 0;
        for (int num : arr) {
            while (stack.peek() != null && stack.peek() <= num) {
                int mid = stack.pop();
                int left = stack.peek() != null ? stack.peek() : Integer.MAX_VALUE;
                int cost = Math.min(left, num) * mid;
                result += cost;
            }
            stack.push(num);
        }

        while (stack.size() >= 3) {
            // stack.peek() will never null
            //noinspection ConstantConditions
            result += stack.pop() * stack.peek();
        }

        return result;
    }

}