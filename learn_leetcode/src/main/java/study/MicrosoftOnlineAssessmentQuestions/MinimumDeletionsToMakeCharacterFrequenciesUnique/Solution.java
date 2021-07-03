package study.MicrosoftOnlineAssessmentQuestions.MinimumDeletionsToMakeCharacterFrequenciesUnique;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        int[] counts = new int[26];
        s.chars().forEach(value -> counts[value - 'a']++);

        Set<Integer> used = new HashSet<>();
        int result = 0;
        for (int count : counts) {
            if (count == 0) continue;
            while (used.contains(count)) {
                count--;
                result++;
            }
            used.add(count);
            if (count != 0) {

            }
        }
        return result;
    }
}
