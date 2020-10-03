package study.dp.MergeIntervals;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null) {
            return null;
        }

        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> tmpResult = new ArrayList<>(intervals.length);
        tmpResult.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = tmpResult.get(tmpResult.size() - 1);
            if (intervals[i][0] >= cur[0] && intervals[i][0] <= cur[1]) {
                cur[1] = Math.max(intervals[i][1], cur[1]);
            } else {
                tmpResult.add(intervals[i]);
            }
        }

        int[][] result = new int[tmpResult.size()][2];
        for (int i = 0; i < tmpResult.size(); i++) {
            result[i] = tmpResult.get(i);
        }

        return result;
    }
}