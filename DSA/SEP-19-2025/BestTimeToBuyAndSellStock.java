// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {
    public int maxProfit(int[] prices) {
        int maximumProfit = 0;

        int i = 0;
        int j = 1;
        while(j<prices.length) {
            int profit = prices[j] - prices[i];
            if(profit < 0) {
                i = j;
            } else if(profit > 0) maximumProfit = Math.max(profit, maximumProfit);
            j++;
        }
        return maximumProfit;
    }
}
