// time and space complexity : O(n) , although space complexity can be reduced to O(1)
// approach is the use of FSM transition
// FSM State transition diagram : https://user-images.githubusercontent.com/55681638/110001737-b13be600-7d3a-11eb-843a-2e12e11fdc9f.jpg
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if(n==0)return 0;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] nothing = new int[n];
        buy[0] = -prices[0];
        for(int day =1;day<n;day++){
            buy[day] = Math.max(buy[day-1],Math.max(nothing[day-1]-prices[day],sell[day-1]-prices[day]));
            sell[day] = Math.max(sell[day-1],buy[day-1]+prices[day]-fee);
            nothing[day] = Math.max(nothing[day-1],sell[day-1]);
        }
        return sell[n-1];
    }
}
