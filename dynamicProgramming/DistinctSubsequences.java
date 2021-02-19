// time complexity : O(2^nm)
/*
  recursive approach :
    --> there are 2 possibilities , either s[n] == t[n] or not
    --> if s[n] == t[m] , we have 2 choices , 
          --> either we can consider matching s[n] and t[m] and goto n-1,m-1.
          --> or we can look for other match of t[m] in s by going to n-1,m.
    --> if s[n] != t[m] , we have to look for other match in n-1,m
    --> base conditions are tricky to find here.
    --> i.e. if m==0, we found a valid match for all character of t in s , so return 1 
    --> if n==0 , we are not able to match all characters of t in s
*/
class Solution {
    public int numDistinct(String s, String t) {
        return recursiveHelper(s,t,s.length(),t.length());
    }
    private int recursiveHelper(String s,String t,int n,int m){
        if(m==0)return 1;
        if(n==0)return 0;
        if(s.charAt(n-1)==t.charAt(m-1))
            return recursiveHelper(s,t,n-1,m-1) + recursiveHelper(s,t,n-1,m);
        return recursiveHelper(s,t,n-1,m);
    }
}
// memoization of above recursive code with time and space complexity : O(nm)
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return memoHelper(s,t,n,m,dp);
    }
    private int memoHelper(String s,String t,int n,int m,int[][] dp){
        if(m==0)return 1;
        if(n==0)return 0;
        if(dp[n][m]!=-1)return dp[n][m];
        if(s.charAt(n-1)==t.charAt(m-1))
            return dp[n][m] =  memoHelper(s,t,n-1,m-1,dp) + memoHelper(s,t,n-1,m,dp);
        return dp[n][m] = memoHelper(s,t,n-1,m,dp);
    }
}
