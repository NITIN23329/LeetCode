// time and space complexity O(n^2)
/*
  approach : top down memoization
      --> for every day i, we have 2 options :
      --> if we did n't bought any stock on day previous than i , we can buy a stock at i or don't buy stock at i
      --> if we bought a stock previously , we can sell it on day i and goto i+2 th day (cooldown of 1 day) or we don't sell it on day i
      --> we return max of 2 cases depending on if we bought stock befor day i or not.
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return recursiveHelper(prices,0,-1,dp);
    }
    private int recursiveHelper(int[] prices,int i,int bought,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][bought+1]!=-1)return dp[i][bought+1];
        if(bought==-1)
            return dp[i][bought+1] = Math.max(recursiveHelper(prices,i+1,i,dp),
                            recursiveHelper(prices,i+1,-1,dp));
        return dp[i][bought+1] =  Math.max(prices[i] - prices[bought] + 
                                          recursiveHelper(prices,i+2,-1,dp),
                                          recursiveHelper(prices,i+1,bought,dp));
    }
}
// time complexity : O(n^2) and space complexity o(n)
/*
    approach : bottom up dp
    // let the dp[i] represents the max profit we get upto day i,
    // if a day is a cooldown day or do nothing day , dp[i] = dp[i-1] as we are making no extra profit on ith day.
    // if we fix our day as sell day , then for this particular sell day , we can buy the stock from date buy = 0 to sell day - 1.
    // for a particular buy day , total profit would be prices[sell] - prices[buy] + max profit we got till buy-2 day(as 1 day is cooldown before buy day so we can take profit of a day before cooldown day) which is stored in dp[buy-2].
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1)return 0;
        int[] dp = new int[n];
        for(int sell=1;sell<n;sell++){
            dp[sell] = dp[sell-1];
            for(int buy=0;buy<sell;buy++){
                dp[sell] = Math.max(dp[sell], 
                                    prices[sell]-prices[buy] + (buy-2>=0?dp[buy-2]:0));
            }
        }
        return dp[n-1];
    }
}
// time and space complexity O(n)
/*  
  approach : using FSM
      --> not very intuitive
      --> explanation of approach : https://www.youtube.com/watch?v=4wNXkhAky3s
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0)return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] nothing = new int[n];
        buy[0] = - prices[0];
        for(int day=1;day<n;day++){
            buy[day] = Math.max(nothing[day-1]-prices[day],buy[day-1]);
            nothing[day] = Math.max(sell[day-1],nothing[day-1]);
            sell[day] = buy[day-1] + prices[day];
        }
        return Math.max(sell[n-1],nothing[n-1]);
    }
}
