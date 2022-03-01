package study.array.SubArrayRanges;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 单调栈
 */
public class Solution2 {
    public long subArrayRanges(int[] nums) {

        int length = nums.length;
        int[] leftGreater = new int[length];
        int[] leftLess = new int[length];
        int[] rightGreater = new int[length];
        int[] rightLess = new int[length];

        Deque<Integer> increasing = new LinkedList<>();
        Deque<Integer> decreasing = new LinkedList<>();

        // left to right
        for (int i = 0; i < length; i++) {
            while (!increasing.isEmpty() && nums[increasing.peekFirst()] > nums[i]) {
                increasing.pop();
            }

            leftLess[i] = increasing.isEmpty() ? -1 : increasing.peekFirst();
            increasing.push(i);

            while (!decreasing.isEmpty() && nums[decreasing.peekFirst()] < nums[i]) {
                decreasing.pop();
            }
            leftGreater[i] = decreasing.isEmpty() ? -1 : decreasing.peekFirst();
            decreasing.push(i);
        }

        increasing.clear();
        decreasing.clear();
        // right to left
        for (int i = length - 1; i >= 0; i--) {
            while (!increasing.isEmpty() && nums[increasing.peekFirst()] >= nums[i]) {
                increasing.pop();
            }

            rightLess[i] = increasing.isEmpty() ? length : increasing.peekFirst();
            increasing.push(i);

            while (!decreasing.isEmpty() && nums[decreasing.peekFirst()] <= nums[i]) {
                decreasing.pop();
            }
            rightGreater[i] = decreasing.isEmpty() ? length : decreasing.peekFirst();
            decreasing.push(i);
        }

        long sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (long) nums[i] * (long) (i - leftGreater[i]) * (long) (rightGreater[i] - i);
            sum -= (long) nums[i] * (long) (i - leftLess[i]) * (long) (rightLess[i] - i);
        }

        return sum;
    }
}
