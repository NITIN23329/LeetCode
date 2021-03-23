// time and space complexity : O(n^2)
// approach : same as longest common substring in 2 given strings. 
class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int max = 1;
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++){
                 if(A[i-1]==B[j-1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                max = Math.max(max,dp[i][j]);
            }
        return max;
    }
}
