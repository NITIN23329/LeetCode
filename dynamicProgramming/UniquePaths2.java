// time and space complexity : o(nm)
/*
  approach :
    --> if a cell at i,j has an obstacle then there is now way to reach n-1,m-1 for that, hence for such cell dp[i][j] = 0
    --> else we can goto right cell i,j+1 and down cell i+1,j , we add both cell's answer to get answer for cell i,j.
*/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        dp[n-1][m-1] = obstacleGrid[n-1][m-1]==0?1:0;
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(j+1<m)
                    dp[i][j] += obstacleGrid[i][j]==0?dp[i][j+1]:0;
                if(i+1<n)
                    dp[i][j] += obstacleGrid[i][j]==0?dp[i+1][j]:0;
            }
        }
        return dp[0][0];
    }
}
