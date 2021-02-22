// recursive solution
/*
  approach : Variation of LCS
    --> if either string is empty , our ans is sum of ASCII value of other non empty string
    --> if s1[n] == s2[m] , we goto f(n-1,m-1)
    --> if s1[n] !=s2[m] , we return minimum of s1[n] + f(n-1,m) and s2[m] + f(n,m-1) 
*/
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return recursiveHelper(s1,s2,s1.length(),s2.length());
    }
    private int recursiveHelper(String s1,String s2,int n,int m){
        if(n==0 || m==0){
            int cost = 0;
            while(m>0){
                cost+=s2.charAt(m-1);
                m--;
            }
            while(n>0){
                cost+=s1.charAt(n-1);
                n--;
            }
            return cost;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return recursiveHelper(s1,s2,n-1,m-1);
        int c1 = s1.charAt(n-1) + recursiveHelper(s1,s2,n-1,m);
        int c2 = s2.charAt(m-1) + recursiveHelper(s1,s2,n,m-1);
        return Math.min(c1,c2);
    }
}
//bottom up dp with time and space complexity : O(nm)
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
        for(int j=1;j<=m;j++)
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int c1 = s1.charAt(i-1) + dp[i-1][j];
                    int c2 = s2.charAt(j-1) + dp[i][j-1];
                    dp[i][j] = Math.min(c1,c2);
                }
        return dp[n][m];
            
    }
}
