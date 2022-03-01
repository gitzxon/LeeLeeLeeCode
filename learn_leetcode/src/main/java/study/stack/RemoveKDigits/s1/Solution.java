package study.stack.RemoveKDigits.s1;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0 ) {
            return num;
        }

        Deque<Integer> increaseStack = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            int value = num.charAt(i) - '0';
            if (increaseStack.size() == 0 || increaseStack.peek() <= 0) {
                increaseStack.push(value);
                continue;
            }

            while (increaseStack.size() != 0 && increaseStack.peek() > value && count < k) {
                increaseStack.pop();
                count++;
            }
            increaseStack.push(value);
        }

        while (count < k && increaseStack.size() != 0) {
            increaseStack.pop();
            count++;
        }

        if (increaseStack.size() == 0) {
            return "0";
        } else {

            StringBuilder sb = new StringBuilder(increaseStack.size());
            while (increaseStack.size() != 0) {
                sb.append(increaseStack.pop());
            }

            while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0' && sb.length() != 1) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.reverse();
            return sb.toString();

        }
    }
}