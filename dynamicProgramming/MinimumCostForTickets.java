// time and space complexity : O(n) where n = 365
/*  
  approach :
      --> make a boolean array for 365 days which tells on which day we will travel
      --> on each day of travel, either we purchase 1 day ticket , 7 days ticket and 30 days ticket
      --> if we buy 30 days ticket at ith day we will next buy another ticket on i+30 similar goes for 7 days tickets and 1 days tickets
      --> if on ith day we dont travel , we goto next day
*/
class Solution {
    public int mincostTickets(int[] days, int[] cost) {
        boolean[] travel = new boolean[366];
        for(int ele : days)travel[ele] = true;
        int[] dp = new int[366];
        Arrays.fill(dp,-1);
        return memoHelper(travel,0,cost,dp);
    }
    private int memoHelper(boolean[] travel,int i,int[] cost,int[] dp){
        if(i>=travel.length)return 0;
        if(dp[i]!=-1)return dp[i];
        if(!travel[i])
            return dp[i] = memoHelper(travel,i+1,cost,dp);
        int d1 = cost[0] + memoHelper(travel,i+1,cost,dp);
        int d7 = cost[1] + memoHelper(travel,i+7,cost,dp);
        int d30 = cost[2] + memoHelper(travel,i+30,cost,dp);
        return dp[i] = Math.min(d1,Math.min(d7,d30));
    }
}
