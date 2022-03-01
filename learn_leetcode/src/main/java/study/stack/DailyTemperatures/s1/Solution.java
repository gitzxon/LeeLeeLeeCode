package study.stack.DailyTemperatures.s1;

import java.rmi.server.RemoteServer;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int[] result = new int[temperatures.length];
        // decrease stack
        Deque<Integer> decreaseStack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (decreaseStack.size() == 0 || temperatures[i] <= temperatures[decreaseStack.peek()]) {
                decreaseStack.push(i);
                continue;
            }
            while (decreaseStack.size() != 0 && temperatures[decreaseStack.peek()] < temperatures[i]) {
                int index = decreaseStack.pop();
                result[index] = i - index;
            }
            decreaseStack.push(i);
        }
        while (decreaseStack.size() != 0) {
            result[decreaseStack.pop()] = 0;
        }
        return result;
    }
}