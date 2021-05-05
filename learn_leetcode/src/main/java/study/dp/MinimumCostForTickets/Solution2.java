package study.dp.MinimumCostForTickets;

import java.util.HashSet;

/**
 * rolling array
 */
class Solution2 {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }

        int[] dp = new int[30];

        for (int eachDay = days[0]; eachDay <= days[days.length - 1]; eachDay++) {

            int i = eachDay % 30;
            int pre = (eachDay - 1) % 30;
            if (!set.contains(eachDay)) {
                dp[i] = dp[pre];
                continue;
            }

            int last = (eachDay - 1) % 30;
            int last7 = (eachDay - 7) % 30;
            int last30 = (eachDay - 30) % 30;
            int num0 = getValueSafe(dp, last) + costs[0];
            int num1 = getValueSafe(dp, last7) + costs[1];
            int num2 = getValueSafe(dp, last30) + costs[2];
            dp[i] = Math.min(num0, Math.min(num1, num2));
        }

        return dp[days[days.length - 1] % 30];
    }

    private int getValueSafe(int[] dp, int i) {
        if (i >= 0 && i < dp.length) {
            return dp[i];
        } else {
            return 0;
        }
    }
}