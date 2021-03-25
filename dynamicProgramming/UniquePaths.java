// time and space complexity : O(nm)
/*
  --> if we are at last column or last row, we can only move down or right respectively.
  --> So initilaization is, fill last row with 1 and last column with 1.
  --> for all other cell, we can goto either right or bottom, hence dp[i][j] = bottom(dp[i+1][j]) + right(dp[i][j+1])
*/
class Solution {
    public int uniquePaths(int n, int m) {
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
            dp[i][m] = 1;
        for(int j=0;j<=m;j++)
            dp[n][j] = 1;
        for(int i=n-1;i>=1;i--)
            for(int j=m-1;j>=1;j--)
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
        return dp[1][1];
    }
}
