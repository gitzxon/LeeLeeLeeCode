package study.dp.LastStoneWeightII;

import java.util.Arrays;

class Solution {

    public int lastStoneWeightII(int[] stones) {
        if (stones == null) {
            return 0;
        }

        if (stones.length == 0) {
            return 0;
        }

        if (stones.length == 1) {
            return stones[0];
        }

        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int rowCount = sum + 1;
        int colCount = stones.length + 1;
        boolean[][] dp = new boolean[rowCount][colCount];
        for (int i = 0; i < colCount; i++) {
            dp[0][i] = true;
        }

        // diff = sum - 2 * sum2
        for (int i = 1; i < colCount; i++) {
            int stone = stones[i - 1];

            for (int j = 1; j <= sum / 2; j++) {

                if (dp[j][i - 1] || (j >= stone && dp[j - stone][i - 1])) {
                    dp[j][i] = true;
                }
            }
            System.out.println("stone = " + i + "\n" + Arrays.toString(dp[i]));

        }

        int sum2 = 0;
        for (int i = 0; i < colCount; i++) {
            for (int j = sum / 2; j > 0; j--) {
                if (dp[j][i]) {
                    sum2 = Math.max(sum2, j);
                }
            }
        }

        return sum - 2 * sum2;
    }
}
