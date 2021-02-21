// time and space complexity : O(n^2)
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
            ans = Math.min(ans,memoHelper(matrix,0,j,dp));
        return ans;

    }
    private int memoHelper(int[][] grid,int r,int c,int [][] dp){
        if(c<0 || c==grid.length)
            return Integer.MAX_VALUE;
        if(r==grid.length-1)
            return grid[r][c];
        if(dp[r][c]!=-1)return dp[r][c];
        int c1 = memoHelper(grid,r+1,c,dp);
        int c2 = memoHelper(grid,r+1,c+1,dp);
        int c3 = memoHelper(grid,r+1,c-1,dp);
        return dp[r][c] = grid[r][c] + Math.min(c1,Math.min(c2,c3));
    }

}
