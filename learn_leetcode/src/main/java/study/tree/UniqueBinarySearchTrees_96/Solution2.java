package study.tree.UniqueBinarySearchTrees_96;

public class Solution2 {

    public static class Solution {
        public int numTrees(int n) {

            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            }

            int[] arr = new int[n + 1];
            arr[0] = 1;
            arr[1] = 1;

            for (int i = 2; i <= n; i++) {
                int sum = i - 1;
                int count = 0;
                for (int a = 0; a <= i - 1; a++) {
                    count += arr[a] * arr[sum - a];
                }
                arr[i] = count;
            }

            return arr[n];
        }
    }
}
