package study.array.SubArrayRanges;

/**
 * 暴力
 */
class Solution {
    public long subArrayRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < nums.length; j++) {
                int end = nums[j];
                min = Math.min(Math.min(start, end), min);
                max = Math.max(Math.max(start, end), max);
                count += max - min;
            }
        }

        return count;
    }
}