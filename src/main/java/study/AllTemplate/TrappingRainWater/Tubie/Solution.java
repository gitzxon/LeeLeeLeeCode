package study.AllTemplate.TrappingRainWater.Tubie;

/**
 *  土鳖解法：
 *  先找到最大的，然后分别往左往右遍历。
 *  思想跟双指针是一样的，但是不够优雅。
 */
class Solution {

    public int trap(int[] heights) {
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < heights.length; i++) {
            if (max < heights[i]) {
                max = heights[i];
                maxIndex = i;
            }
        }

        int result = 0;

        int maxSoFar = -1;
        for (int i = 0; i < maxIndex; i++) {
            if (maxSoFar < heights[i]) {
                maxSoFar = heights[i];
            }

            result += (maxSoFar - heights[i]);
        }

        maxSoFar = -1;
        for (int i = heights.length - 1; i > maxIndex; i--) {
            if (maxSoFar < heights[i]) {
                maxSoFar = heights[i];
            }

            result += (maxSoFar - heights[i]);
        }
        return result;
    }
}