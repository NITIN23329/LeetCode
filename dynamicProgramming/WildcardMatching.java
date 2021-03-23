// time and space complexity : O(nm)
/*
  approach : consider different cases.
  1) if p is empty(j==s.length()), then s has to be empty.
  2) if s is empty(i==s.length()), then p must be empty or have only "*" character in it.
  3) if p[j]=='?' then we goto next character by f(i+1,j+1)
  4) if p[i]='*' then we have 2 possibilities :
      a) either we can skip s[i] and goto f(i+1,j) case : s = "abcd" and p = "a*d", here "bc" in s will be skipped.
      b) either we can skip p[j] and goto f(i,j+1) case : s = "abc" and p = "a*b*c", here both "*" in t will be skipped.
  5) if p[i] is a character check if s[i] == p[j] and goto  next character by f(i+1,j+1).
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int[][] dp = new int[n+1][p.length()+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return helper(s,p,0,0,dp);
    }
    private boolean helper(String s,String p,int i,int j,int[][] dp){
        if(dp[i][j]!=-1)return dp[i][j]==1;
        boolean ans;
        if(j==p.length())
            ans =  i==s.length();
       else if(i==s.length()) 
           ans =  p.charAt(j)=='*' && helper(s,p,i,j+1,dp);
        else if(p.charAt(j)=='?')
            ans = helper(s,p,i+1,j+1,dp);
        else if(p.charAt(j)=='*')
            ans = helper(s,p,i,j+1,dp) || helper(s,p,i+1,j,dp);
        else 
            ans = s.charAt(i)==p.charAt(j) && helper(s,p,i+1,j+1,dp);
        dp[i][j] = ans?1:0;
        return ans;
    }
}
