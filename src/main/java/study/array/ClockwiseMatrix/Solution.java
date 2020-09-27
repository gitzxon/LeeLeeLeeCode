package study.array.ClockwiseMatrix;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * 稍微顺畅一点的思路。
 * 跟 {@link SolutionSucks} 差不多。只不过判断结束的条件放在了 while 的外面，看起来好看了一点。
 * 一开始用 array list 接收 result。
 * 后来改成用 int[] 接收，效率会高一点。
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null) {
            return new int[0];
        }

        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int left = 0;
        int top = 0;
        int right = colCount - 1;
        int bottom = rowCount - 1;
        int cur = 0;
        int[] result = new int[rowCount * colCount];
        while (left < right && top < bottom) {
            for (int j = left; j < right; j++) {
                result[cur] = matrix[top][j];
                cur++;
            }

            for (int i = top; i < bottom; i++) {
                result[cur] = matrix[i][right];
                cur++;
            }

            for (int j = right; j > left; j--) {
                result[cur] = matrix[bottom][j];
                cur++;
            }

            for (int i = bottom; i > top; i--) {
                result[cur] = matrix[i][left];
                cur++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                result[cur] = matrix[i][left];
                cur++;

            }
        } else if (top == bottom) {
            for (int j = left; j <= right; j++) {
                result[cur] = matrix[top][j];
                cur++;
            }
        }

        return result;
    }
}