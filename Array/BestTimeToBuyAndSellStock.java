// time complexity O(n) and space complexity O(1)
// approach : for every i , find the min price in range(0,i-1), we will sell our stock on ith day , if we get more profit from previous day.
class Solution {
    public int maxProfit(int[] prices) {
        int currMin = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(profit< prices[i] - currMin)
                profit = prices[i] - currMin;
            currMin = Math.min(currMin,prices[i]);
        }
        return profit;
    }
}
// time and space complexity : O(n) , although space complexity can be reduced to O(1)
// Done via FSM or state transistions . Note : most stock buy and sell problem can be done with FSM state transistion
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for(int day=1;day<n;day++){
            buy[day] = Math.max(buy[day-1],-prices[day]);
            sell[day] = Math.max(sell[day-1],buy[day-1] + prices[day]);
        }
        return sell[n-1];
    }
}
