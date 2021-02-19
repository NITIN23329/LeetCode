// time complexity O(3^nm)
/*  recursive approach :
        --> if either string is empty , then the # of oprn to convert both is s1.length() if s2 is empty or s2.length() if s1 is empty
        --> if s1[n] == s2[m] , we need not to do any operation so goto n-1,m-1
        --> else we have 3 choices , either we can delete s1[n] , and goto n-1,m
        --> either we replace s1[n] to s2[m] , and goto n-1,m-1
        --> or we can add s2[m] to s1 and goto n,m-1.
*/
class Solution {
    public int minDistance(String s1, String s2) {
        return recursiveHelper(s1,s2,s1.length(),s2.length());
    }
    private int recursiveHelper(String s1,String s2,int n,int m){
        if(n==0)return m;
        if(m==0)return n;
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return recursiveHelper(s1,s2,n-1,m-1);
        int c1 = recursiveHelper(s1,s2,n-1,m-1);    //replaced s1[n] to s2[m]
        int c2 = recursiveHelper(s1,s2,n-1,m);      // deleted s1[n]
        int c3 = recursiveHelper(s1,s2,n,m-1);      // added s2[m] to s1
        return 1+Math.min(c1,Math.min(c2,c3));
    }
}
// memoizations of above recursive code
// time and space complexity : O(nm)
class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return memeoHelper(s1,s2,s1.length(),s2.length(),dp);
    }
    private int memeoHelper(String s1,String s2,int n,int m,int[][] dp){
        if(n==0)return m;
        if(m==0)return n;
        if(dp[n][m]!=-1)return dp[n][m];
        if(s1.charAt(n-1)==s2.charAt(m-1))
            return dp[n][m] = memeoHelper(s1,s2,n-1,m-1,dp);
        int c1 = memeoHelper(s1,s2,n-1,m-1,dp);    //replaced s1[n] to s2[m]
        int c2 = memeoHelper(s1,s2,n-1,m,dp);      // deleted s1[n]
        int c3 = memeoHelper(s1,s2,n,m-1,dp);      // added s2[m] to s1
        return dp[n][m] = 1 + Math.min(c1,Math.min(c2,c3));
    }
}
// bottom up dp with time and space complexity : O(nm)
class Solution {
    public int minDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        //initialization 
        // if s1 is of length i and s2 is length 0 , ans is i
        // if s2 is of length j and s1 is length 0 , ans is j
        for(int i=0;i<=n;i++)
            dp[i][0] = i;
        for(int j=0;j<=m;j++)
            dp[0][j] = j;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
                    int c1 = dp[i-1][j-1];  //replaced s1[i] to s2[j]
                    int c2 = dp[i-1][j];    // deleted s1[i]
                    int c3 = dp[i][j-1];    // added s2[mj to s1
                    dp[i][j] = 1 + Math.min(c1,Math.min(c2,c3));
                }
        return dp[n][m];
    }
}
