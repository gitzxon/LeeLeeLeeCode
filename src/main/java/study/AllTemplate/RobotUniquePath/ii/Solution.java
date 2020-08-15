package study.AllTemplate.RobotUniquePath.ii;

/**
 * 二维数组
 */
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rowCount = obstacleGrid.length;
        int colCount = obstacleGrid[0].length;
        int[][] dp = new int[rowCount][colCount];

        dp[0][0] = 1;
        for (int row = 1; row < rowCount; row++) {
            int col = 0;
            dp[row][col] = getValueWithObstacles(obstacleGrid, row, col, dp[row - 1][col]);
        }

        for (int col = 1; col < colCount; col++) {
            int row = 0;
            dp[row][col] = getValueWithObstacles(obstacleGrid, row, col, dp[row][col - 1]);
        }

        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                int top = getValueWithObstacles(obstacleGrid, i, j, dp[i - 1][j]);
                int left = getValueWithObstacles(obstacleGrid, i, j, dp[i][j - 1]);
                dp[i][j] = top + left;
            }
        }

        return dp[rowCount - 1][colCount - 1];

    }

    int getValueWithObstacles(
            int[][] obstacleGrid,
            int i, int j,
            int defaultValue
    ) {
        if (obstacleGrid[i][j] == 1) {
            return 0;
        } else {
            return defaultValue;
        }
    }

}