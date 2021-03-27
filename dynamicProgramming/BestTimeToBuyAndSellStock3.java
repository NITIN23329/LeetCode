// time and space complexity : o(n)
/*
  approach :
    --> The only possible ways to do 2 transactions is B1->S1->B2->S2 (non overlaping)
    --> we can partition the given array into 2 subarray. Suppose we do partiton at index i.
    --> So we can find maximum profit we can get from day 0 to day i and from day i to day n-1.
    -->  Finding maximum profit from day i to day j can be done using : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    --> we will sum these 2 profit to get maximum profit with atmost 2 transactions.
    --> Do this for every i from 0 to n-1 and find max of all i's
*/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // buy1[i] represents maximum profit we can get btw day 0 to i
        int[] buy1 = new int[n];
        int min = prices[0];
        for(int i=1;i<n;i++){
            buy1[i] = Math.max(buy1[i-1],prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        // buy2[i] represents maximum profit we can get btw day i to day n-1.
        int[] buy2 = new int[n];
        int max = prices[n-1];
        for(int i=n-2;i>=0;i--){
            buy2[i] = Math.max(buy2[i+1],max - prices[i]);
            max = Math.max(max,prices[i]);
        }
        // now we will find maximum of ( profit we can get from day 0 to i + profit we can get from i to n-1 ).
        int ans = 0;
        for(int i=0;i<n;i++)
            ans = Math.max(ans,buy1[i]+buy2[i]);
        return ans;
    }
}
