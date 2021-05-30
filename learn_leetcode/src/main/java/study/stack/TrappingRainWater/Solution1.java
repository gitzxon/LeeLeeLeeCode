package study.stack.TrappingRainWater;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 栈
 */
public class Solution1 {
    public int trap(int[] heights) {
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {

            if (stack.isEmpty() || heights[stack.peek()] > heights[i]) {
                stack.push(i);
                continue;
            }

            while (heights[stack.peek()] < heights[i]) {
                int oldIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int leftMaxIndex = stack.peek();
                int rightMaxIndex = i;
                int len = rightMaxIndex - leftMaxIndex - 1;
                count += (Math.min(heights[leftMaxIndex], heights[rightMaxIndex]) - heights[oldIndex]) * len;
            }

            stack.push(i);
        }

        return count;
    }
}
