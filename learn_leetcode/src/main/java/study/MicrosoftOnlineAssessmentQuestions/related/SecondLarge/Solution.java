package study.MicrosoftOnlineAssessmentQuestions.related.SecondLarge;

class Solution {
    public int secondHighest(String s) {

        int highest = -1;
        int secondHighest = -1;
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (value < '0' || value > '9') {
                continue;
            }

            int cur = value - '0';
            if (cur > highest) {
                secondHighest = highest;
                highest = cur;
            } else if (cur > secondHighest && cur != highest) {
                secondHighest = cur;
            }
        }

        return secondHighest;
    }
}