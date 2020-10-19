package study.array.ClockwiseMatrix;

import org.junit.Test;

import java.util.Arrays;

public class SolutionSucksTest {

    @Test
    public void spiralOrder() {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };


        int[][] nums1 = {
                {1, 2, 3}
        };
        int[][] nums2 = {
                {1},
                {2},
                {3}
        };

        int[][] nums3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
        };


        int[][] nums4 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
        };

        int[] result = new Solution().spiralOrder(nums);
        System.out.println(Arrays.toString(result));
    }
}