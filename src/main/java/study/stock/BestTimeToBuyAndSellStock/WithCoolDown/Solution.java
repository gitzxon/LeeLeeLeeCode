package study.stock.BestTimeToBuyAndSellStock.WithCoolDown;

class Solution {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) {
            return 0;
        }

        int days = prices.length;
        int[] s0 = new int[days];
        int[] s1 = new int[days];
        int[] s2 = new int[days];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < days; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i], s1[i - 1]);
            s2[i] = s1[i - 1] + prices[i];
        }

        return Math.max(s0[days - 1], s2[days - 1]);

    }
}