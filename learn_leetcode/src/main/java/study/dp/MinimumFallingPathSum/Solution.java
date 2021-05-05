package study.dp.MinimumFallingPathSum;

class Solution {
    public int minFallingPathSum(int[][] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0 || nums[0].length == 0) {
            return 0;
        }

        int row = nums.length;
        int col = nums[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (i == 0) {
                    dp[i][j] = nums[i][j];
                } else {
                    int left = Integer.MAX_VALUE;
                    if (j != 0) {
                        left = dp[i - 1][j - 1];
                    }
                    int mid = dp[i - 1][j];

                    int right = Integer.MAX_VALUE;
                    if (j != col - 1) {
                        right = dp[i - 1][j + 1];
                    }

                    dp[i][j] = nums[i][j] + Math.min(mid, Math.min(left, right));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < col; i++) {
            min = Math.min(dp[row - 1][i], min);
        }

        return min;
    }
}