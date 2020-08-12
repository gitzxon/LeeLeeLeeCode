package study.AllTemplate.HouseRobber.i;

class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            if (i == 0) {
                dp[i] = nums[0];
            } else if (i == 1) {
                dp[i] = Math.max(nums[0], nums[1]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}