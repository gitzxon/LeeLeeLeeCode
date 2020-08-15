package study.AllTemplate.RobotUniquePath.ii.optimized;

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

        int[] dp = new int[colCount];
        dp[0] = 1;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int top = getValueWithObstacles(
                        obstacleGrid, i, j,
                        dp[j]
                );

                int left = 0;
                if (j - 1 >= 0) {
                    left = getValueWithObstacles(
                            obstacleGrid, i, j,
                            dp[j - 1]
                    );
                }
                dp[j] = left + top;
            }
        }

        return dp[colCount - 1];
    }

    private int getValueWithObstacles(
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