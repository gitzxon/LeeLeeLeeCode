package study.stack.SumofSubarrayMinimums;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int sumSubarrayMins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        Deque<Integer> numsStack = new ArrayDeque<>(nums.length);
        Deque<Integer> lensStack = new ArrayDeque<>(nums.length);
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (!numsStack.isEmpty() && numsStack.peek() > nums[i]) {
                len += lensStack.pop();
                numsStack.pop();
            }

            left[i] = len;
            lensStack.push(len);
            numsStack.push(nums[i]);
        }

        numsStack.clear();
        lensStack.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            int len = 1;
            while (!numsStack.isEmpty() && numsStack.peek() >= nums[i]) {
                len += lensStack.pop();
                numsStack.pop();
            }

            right[i] = len;
            lensStack.push(len);
            numsStack.push(nums[i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        long result = 0;
        long mod = (int) (1e9 + 7);
        for (int i = 0; i < nums.length; i++) {
            result += (long) left[i] * right[i] * nums[i];
            result = result % mod;
        }
        return (int) result;
    }
}