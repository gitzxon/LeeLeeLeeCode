package study.dp.LastStoneWeightII;

import java.util.BitSet;

/**
 * 优化内存占用
 *
 */
public class Solution1 {
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
        boolean[] dp = new boolean[rowCount];
        dp[0] = true;

        for (int stone : stones) {
            for (int j = sum / 2; j >= stone; j--) {
                dp[j] |= dp[j - stone];
            }
        }

        // diff = sum - 2 * sum2
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[i]) {
                return sum - i * 2;
            }
        }

        return 0;
    }

}
