package study.AllTemplate.TrappingRainWater.dp;

class Solution {
    public int trap(int[] height) {

        if (height == null || height.length <= 1) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            leftMax[i] = maxLeft;
        }

        int maxRight = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i]);
            rightMax[i] = maxRight;
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return sum;
    }
}