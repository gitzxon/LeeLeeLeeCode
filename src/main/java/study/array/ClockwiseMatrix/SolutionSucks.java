package study.array.ClockwiseMatrix;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：7 ms, 在所有 Java 提交中击败了6.20%的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了73.94%的用户
 * sucks
 */
class SolutionSucks {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null) {
            return new int[0];
        }
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int totalCount = rowCount * colCount;

        int curCount = 0;
        int startRow = 0;
        int startCol = 0;
        List<Integer> list = new ArrayList<>();

        while (curCount < totalCount) {

            if (startCol == colCount - 1 - startCol) {
                for (int i = startRow; i <= rowCount - 1 - startRow; i++) {
                    list.add(matrix[i][startCol]);
                    curCount++;
                }
                continue;
            } else if (startRow == rowCount - 1 - startRow) {
                for (int j = startCol; j <= colCount - 1 - startCol; j++) {
                    list.add(matrix[startRow][j]);
                    curCount++;
                }
                continue;
            }

            for (int j = startCol; j < colCount - 1 - startCol; j++) {
                list.add(matrix[startRow][j]);
                curCount++;
            }

            for (int i = startRow; i < rowCount - 1 - startRow; i++) {
                list.add(matrix[i][colCount - 1 - startCol]);
                curCount++;
            }

            for (int j = colCount - 1 - startCol; j > startCol; j--) {
                list.add(matrix[rowCount - 1 - startRow][j]);
                curCount++;
            }

            for (int i = rowCount - 1 - startRow; i > startRow; i--) {
                list.add(matrix[i][startCol]);
                curCount++;
            }

            startRow++;
            startCol++;
        }

        int[] resultArray = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resultArray[i] = list.get(i);
        }

        return resultArray;
    }

}