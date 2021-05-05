package study.dp.MinimumPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowCount = grid.length;
        int colCount = grid[0].length;

        int[][] dp = new int[rowCount][colCount];

        dp[0][0] = grid[0][0];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[rowCount - 1][colCount - 1];
    }
}