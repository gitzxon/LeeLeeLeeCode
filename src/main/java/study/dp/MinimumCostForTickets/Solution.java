package study.dp.MinimumCostForTickets;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        if (days == null || days.length == 0) {
            return 0;
        }

        Queue<int[]> last7 = new LinkedList<>();
        Queue<int[]> last30 = new LinkedList<>();

        int cost = 0;
        for (int day : days) {

            while (!last7.isEmpty() && last7.peek()[0] + 7 <= day) {
                last7.poll();
            }

            while (!last30.isEmpty() && last30.peek()[0] + 30 <= day) {
                last30.poll();
            }

            last7.offer(offerValue(day, cost, costs[1]));
            last30.offer(offerValue(day, cost, costs[2]));

            int value1 = cost + costs[0];
            int value2 = peekCost(last7);
            int value3 = peekCost(last30);
            System.out.println("value1 = " + value1);
            System.out.println("value2 = " + value2);
            System.out.println("value3 = " + value3);

            cost = Math.min(cost + costs[0], Math.min(peekCost(last7), peekCost(last30)));

            System.out.println("cost = " + cost);
        }

        return cost;
    }

    private int[] offerValue(int index, int curTotalCost, int todayCost) {
        int[] value = new int[2];
        value[0] = index;
        value[1] = curTotalCost + todayCost;
        return value;
    }

    private int peekCost(Queue<int[]> queue) {
        if (queue.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return queue.peek()[1];
    }
}