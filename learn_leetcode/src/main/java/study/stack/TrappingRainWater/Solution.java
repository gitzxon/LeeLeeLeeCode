package study.stack.TrappingRainWater;

/**
 * 双指针
 */
class Solution {
    public int trap(int[] heights) {
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        int leftMax = -1;
        int rightMax = -1;
        int i = 0;
        int j = heights.length - 1;
        int count = 0;
        while (i < j) {
            leftMax = Math.max(leftMax, heights[i]);
            rightMax = Math.max(rightMax, heights[j]);

            if (heights[i] <= heights[j]) {
                count += Math.min(leftMax, rightMax) - heights[i];
                i++;
            } else {
                count += Math.min(leftMax, rightMax) - heights[j];
                j--;
            }

        }

        return count;
    }
}