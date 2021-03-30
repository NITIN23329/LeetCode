// time and space complexity : O(nk)
/*
  approach :
    --> for every point in x-axis, it have 2 states, either it is a part of line segment or it it empty(no line).
    --> if we have a current running line, we can either end it or continue running it.
    --> if previous state is empty(i.e. no running line at x-1 ) then at point x , we can start a new line or we dont .
    --> if we creted all k line segments, we return 1.
    
*/
class Solution {
    int mod = (int)1e9+7;
    public int numberOfSets(int n, int k) {
        long[][][] dp = new long[n][k+1][2];
        for(int i=0;i<n;i++)
            for(int j=0;j<=k;j++)
                dp[i][j] = new long[]{-1,-1};
        return (int)helper(0,n,0,k,dp);
    }
    private long helper(int i,int n,int prev_state,int k,long[][][] dp){
        if(k==0)return 1;
        if(i==n)return 0;
        if(dp[i][k][prev_state]!=-1)return dp[i][k][prev_state];
        long ans = 0;
        if(prev_state==0)
            ans += helper(i+1,n,0,k,dp) + helper(i+1,n,1,k,dp);
        else if(prev_state==1)
            ans += helper(i+1,n,1,k,dp) + helper(i,n,0,k-1,dp);
        return dp[i][k][prev_state] = ans%mod;
    }
}
