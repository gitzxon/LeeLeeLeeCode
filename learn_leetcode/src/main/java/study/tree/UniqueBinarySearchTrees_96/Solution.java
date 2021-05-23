package study.tree.UniqueBinarySearchTrees_96;

class Solution {
    public int numTrees(int n) {
        return performCountTrees(n);
    }

    private int performCountTrees(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 5;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int left = performCountTrees(i);
            int right = performCountTrees(n - i - 1);
            int multiForLeft = left;
            if (left <= 1) {
                multiForLeft = 1;
            }
            int multiForRight = right;
            if (right <= 1) {
                multiForRight = 1;
            }
            count += multiForLeft * multiForRight;
        }

        return count;
    }
}