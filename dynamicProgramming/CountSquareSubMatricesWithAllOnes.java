// Time and space complexity : O(nm)
/* 
    --> First for every cell we need to find the count the # of squares ending at that cell.
      --> This can be done using the maximal rectangle approach.
        --> if dp[i][j] = 3, it means we can make square of side 1,2, and 3 using the cell{i,j} as the bottom right cell of every square we created.
        --> If arr[i][j] = 0, then dp[i][j] = 0.
        --> else dp[i][j] = 1 + min(dp[i-1][j] , dp[i-1][j-1] , dp[i][j-1])

    --> After this we need to count the # of square submatrices.
        --> We gonna store this in dp table again. dp[i][j] tell the total # of square submatrices upto cell{i,j}
        --> dp[i][j] = ( dp[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] ) . 
        --> We subtract  dp[i-1][j-1] once cuz it has been added to both dp[i-1][j] and dp[i][j-1]
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int j=0;j<m;j++)dp[0][j] = matrix[0][j];
        for(int i=0;i<n;i++)dp[i][0] = matrix[i][0];
        for(int i=1;i<n;i++)
            for(int j=1;j<m;j++)
                dp[i][j] = matrix[i][j] * (1 + Math.min(dp[i-1][j-1],
                                        Math.min(dp[i][j-1],dp[i-1][j])));
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                int a = (i==0||j==0)?0:dp[i-1][j-1];
                int b = i==0?0:dp[i-1][j];
                int c = j==0?0:dp[i][j-1];
                dp[i][j]  += (b + c - a);
        }
        return dp[n-1][m-1];
    }
}
