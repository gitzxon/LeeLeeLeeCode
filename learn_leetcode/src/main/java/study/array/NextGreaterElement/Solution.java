package study.array.NextGreaterElement;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution{
    public static long[] nextLargerElement(long[] arr) {
        if (arr == null) {
            return null;
        }

        int n = arr.length;
        if (n == 0) {
            return new long[0];
        }
        if (n == 1) {
            long[] result = new long[1];
            result[0] = -1;
            return result;
        }
        Deque<Integer> stack = new LinkedList<>();

        long[] result = new long[n];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int index = stack.pop();
                result[index] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            result[idx] = -1;
        }

        return result;
    }
}
