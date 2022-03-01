package topic.swordtooffer.combinesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> resultContainer = new ArrayList<>();
        search(
                candidates,
                resultContainer,
                target,
                new ArrayList<>(),
                0,
                0
        );
        return resultContainer;
    }

    private void search(
            int[] candidates,
            List<List<Integer>> resultContainer,
            int target,
            List<Integer> idxList,
            int idx,
            int curSum
    ) {
        if (curSum == target) {
            List<Integer> result = new ArrayList<>(idxList.size());
            for (int i = 0; i < idxList.size(); i++) {
                result.add(candidates[idxList.get(i)]);
            }
            resultContainer.add(result);
            return;
        } else if (curSum > target) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if (i - 1 >= 0
                    && candidates[i - 1] == candidates[i]
                    && idxList.size() != 0
                    && idxList.get(idxList.size() - 1) != i - 1
            ) {
                continue;
            }

            idxList.add(i);
            search(
                    candidates,
                    resultContainer,
                    target,
                    idxList,
                    i,
                    curSum + candidates[i]
            );
            idxList.remove(idxList.size() - 1);
        }
    }
}