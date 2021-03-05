// time and space compexity O(n)
/*  approach :
      --> if we are at ith index  , 
          --> we can either pay from cost[i] and goto next indeces
          -->or we can pay for cost[i+1] and goto next indeces;
*/
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return recursive(cost,0,dp);
    }
    private int recursive(int[] arr,int i,int[] dp){
        if(i>=arr.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int s0 = arr[i]+ recursive(arr,i+1,dp);
        int s1 =arr[i+1] + recursive(arr,i+2,dp);
        return dp[i] = Math.min(s0,s1);
    }
    
}
// time and space complexity :O(n) , however space complexity can be reduce to O(1) 
// bottom up dp
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int[n+1];
        dp[0] = cost[0];
        dp[1]= cost[1];
        for(int i=2;i<=n;i++)
            dp[i] = Math.min(dp[i-1],dp[i-2]) + (i==n? 0 : cost[i]);
        return dp[n];
    }
}
