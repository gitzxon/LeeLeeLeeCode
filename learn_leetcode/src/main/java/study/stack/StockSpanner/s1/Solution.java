package study.stack.StockSpanner.s1;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class StockSpanner {

    Deque<Integer> decreaseStack = new LinkedList<>();
    List<Integer> allPrices = new ArrayList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        allPrices.add(price);

        if (decreaseStack.size() == 0 || allPrices.get(decreaseStack.peek()) > price) {
            decreaseStack.push(allPrices.size() - 1);
            return 1;
        }

        while (decreaseStack.size() != 0 && allPrices.get(decreaseStack.peek()) <= price) {
            decreaseStack.pop();
        }
        int days;
        if (decreaseStack.size() != 0) {
            days = allPrices.size() - 1 - decreaseStack.peek();
        } else {
            days = allPrices.size();
        }
        decreaseStack.push(allPrices.size() - 1);
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */