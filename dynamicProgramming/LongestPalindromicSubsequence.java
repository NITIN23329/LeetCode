// time and space complexity : O(n^2)
/*
  approach : palindromic subsequence are those subsequence which are exactly same if we traverse from left to right and right to left 
  -->traversing left to right is done with the help of s
  --> traversing right to left is done with the help of reverse of s = t.
  --> find LCS in s and t, that will be the length of longest palindromic subsequence.
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[N+1][N+1];
        for(int n=1;n<=N;n++)
            for(int m=1;m<=N;m++){
                if(s.charAt(n-1)==t.charAt(m-1))
                    dp[n][m] = 1 + dp[n-1][m-1];
                else 
                    dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
            }
        return dp[N][N];
    }
}
