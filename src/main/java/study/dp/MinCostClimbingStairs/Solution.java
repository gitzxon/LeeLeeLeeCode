package study.dp.MinCostClimbingStairs;

class Solution {

    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length <= 2) {
            return 0;
        }

        int len = cost.length + 1;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[dp.length - 1];
    }

}