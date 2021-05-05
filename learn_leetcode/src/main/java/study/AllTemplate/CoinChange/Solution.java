package study.AllTemplate.CoinChange;

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {

        if (coins == null || coins.length == 0) {
            if (amount == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {

            for (int coin : coins) {
                int pre = i - coin;
                if (pre >= 0 && dp[pre] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[pre] + 1);
                }
            }
        }
        
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}