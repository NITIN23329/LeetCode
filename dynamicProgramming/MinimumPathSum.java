// time and space compelxity : O(nm)
/*
  approach :
    --> if we are at last row, we can only goto right 
    --> if we are at last column, we can only goto down
    --> else we can goto either right or down, but we will go where our path sum in minimum.
*/
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for(int i=n-2;i>=0;i--)
            dp[i][m-1] = grid[i][m-1] + dp[i+1][m-1];
        for(int j=m-2;j>=0;j--)
            dp[n-1][j] = grid[n-1][j] + dp[n-1][j+1];
        for(int i=n-2;i>=0;i--)
            for(int j=m-2;j>=0;j--)
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j],dp[i][j+1]);
        return dp[0][0];
            
    }
}
