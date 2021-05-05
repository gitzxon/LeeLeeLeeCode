package study.dp.KeyboardOf2Keys;

import java.util.Arrays;

class Solution {

    public int minSteps(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}