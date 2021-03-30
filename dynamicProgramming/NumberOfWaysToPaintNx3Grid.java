// time and space complexity : O(27*n)
// try out all possible ways to color a column and select only valid ways
class Solution {
    int mod = (int)1e9+7;
    public int numOfWays(int n) {
        long[][][][] dp = new long[n][3][3][3];
        for(int i=0;i<n;i++)
            for(int j=0;j<3;j++)
                for(int k=0;k<3;k++)
                    dp[i][j][k] = new long[]{-1,-1,-1};
        return (int)helper(0,n,-1,-1,-1,dp);
    }
    private long helper(int i,int n,int a,int b,int c,long[][][][] dp){
        if(i==n)return 1;
        if(a!=-1 && dp[i][a][b][c]!=-1)return dp[i][a][b][c];
        long ans = 0;
        for(int na=0;na<3;na++)
            for(int nb=0;nb<3;nb++)
                for(int nc=0;nc<3;nc++){
                    if(isPossible(a,b,c,na,nb,nc))
                        ans += helper(i+1,n,na,nb,nc,dp);
                }
        if(a!=-1)dp[i][a][b][c] = ans%mod;
        return ans%mod;  
    }
    private boolean isPossible(int a,int b,int c,int na,int nb,int nc){
        return na!=a && nb!=b && nc!=c && na!=nb && nb!=nc;
    }
}
