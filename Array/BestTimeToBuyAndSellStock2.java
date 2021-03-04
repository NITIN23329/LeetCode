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
// time and space complexity : O(n) , although, we can reduce space complexity to O(1)
// this solution is done using FSM , FSM : https://user-images.githubusercontent.com/55681638/109997644-6ae48800-7d36-11eb-88a6-b4eab7a91032.jpg

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] nothing = new int[n];
        buy[0] = -prices[0];
        for(int day=1;day<n;day++){
            buy[day] =Math.max(buy[day-1],Math.max(nothing[day-1]-prices[day],sell[day-1]-prices[day]));
            sell[day] = Math.max(sell[day-1] , buy[day-1] + prices[day]);
            nothing[day] = Math.max(nothing[day-1] , sell[day-1]);
        }
        return sell[n-1];
    }
}
