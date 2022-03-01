package study.dp.CountSquareSubmatricswithAllOnes;

class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int result = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                if (i == 0 || j == 0) {
                    result += 1;
                } else {
                    int top = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int leftTop = matrix[i - 1][j - 1];
                    int value = Math.min(top, Math.min(left, leftTop)) + 1;
                    result += value;
                    matrix[i][j] = value;
                }
            }
        }
        return result;
    }
}