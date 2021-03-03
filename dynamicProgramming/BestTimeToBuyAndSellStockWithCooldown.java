// time and space complexity O(n^2)
/*
  approach :
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
