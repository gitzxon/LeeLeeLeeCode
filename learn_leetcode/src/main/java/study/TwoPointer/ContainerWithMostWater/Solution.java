package study.TwoPointer.ContainerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int max = -1;
        while (i <= j) {
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}