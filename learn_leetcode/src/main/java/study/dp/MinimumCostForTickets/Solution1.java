package study.dp.MinimumCostForTickets;

import java.util.HashSet;

/**
 * 遍历 calendar
 * 通过 HashSet 确定 calendar 的 day 是否是在 days 数组中。
 *
 * 但是，这个方法用了 365 天。因为我们最多只关心 30 天，所以，可以简化。
 * rolling array
 */
class Solution1 {

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        int[] dp = new int[365 + 1];
        HashSet<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }
        for (int i = 1; i < dp.length; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }

            int num0 = dp[Math.max(0, i - 1)] + costs[0];
            int num1 = dp[Math.max(0, i - 7)] + costs[1];
            int num2 = dp[Math.max(0, i - 30)] + costs[2];
            dp[i] = Math.min(num0, Math.min(num1, num2));
        }

        return dp[dp.length - 1];
    }
}