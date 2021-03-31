// time complexity : O(m*n*target*n) and space compelxity : O(m*n*target)
/*
  approach : This is simple choice based question
  --> In order to find neighbourhoods, we must know house color of previous house
  --> if previous house color is not as same house color we reduce our group by 1 as neighbhourhood changes
  --> We can only color those houses which are not colored yet, house[i] == 0.
*/
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m][n+2][target+1];
        for(int i=0;i<m;i++)
            for(int j=0;j<n+2;j++)
                Arrays.fill(dp[i][j],-2);
        return helper(0,n+1,houses,target,n,cost,dp);
    }
    private int helper(int i,int prevHouseColor,int[] house,int groups,int colors,int[][] cost,int[][][] dp){
        if(house.length==i)return groups==0?0:-1;
        if(groups<0)return -1;
        if(dp[i][prevHouseColor][groups]!=-2)return dp[i][prevHouseColor][groups];
        if(house[i]!=0){
            if(prevHouseColor!=house[i])
                return dp[i][prevHouseColor][groups] = helper(i+1,house[i],house,groups-1,colors,cost,dp);
            return dp[i][prevHouseColor][groups] = helper(i+1,house[i],house,groups,colors,cost,dp);
        }
        int ans = Integer.MAX_VALUE;
        for(int c=1;c<=colors;c++){
            int next;
            if(prevHouseColor!=c)
                 next = helper(i+1,c,house,groups-1,colors,cost,dp);
            else 
                next = helper(i+1,c,house,groups,colors,cost,dp);
            if(next!=-1)
                ans = Math.min(ans,cost[i][c-1]+next);
        }
        return dp[i][prevHouseColor][groups] = ans == Integer.MAX_VALUE? -1 : ans;
        
    }
}
