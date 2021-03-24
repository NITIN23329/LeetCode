// time and space complexity : O(n^2)
// approach : same as LCS
// find the LCS of string left to right and right to left.
// remove or add all those characters which are not in this LCS. 
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+2][n+2];
        for(int i=1;i<=n;i++)
            for(int j=n;j>=1;j--)
                if(s.charAt(i-1)==s.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j+1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j+1]);
        return n - dp[n][1];
    }
}
