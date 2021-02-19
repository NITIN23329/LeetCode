// time complexity O(n) and space complexity O(1)
// we will try to acheive all profits available
// so we will add all profits we can take to our result
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i=1;i<prices.length;i++)
            ans+= Math.max(0,prices[i]-prices[i-1]);
        return ans;
    }
}
