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
