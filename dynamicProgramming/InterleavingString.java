/*
--> if we take i,j,k for string s1, s2, s3 then time and space complexity for memoization is O(len(s3)*len(s1)*len(s2)) (3D)
--> Some optimzation can be done to reduce 3D dp to 2D dp
--> observations :
      --> for s3 to be a interleaving string, s3 should contains all and evey characters of s1 and s2 => len(s3) = len(s1) + len(s2)
      --> if we processing for ith index in s1 and jth index in s2, it means we are processing i+j th character in s3.
      --> if we processed i-1 chars in s1 and j chars in s2 and going to ith char in s1, then in s3 we have processed ( (i-1) + j ) and going to ((i-1) + j + 1) = i+j th char in s3.
      --> if we processed i chars in s1 and j-1 chars in s2 and going to jth char in s2, then in s3 we have processed ( i + (j-1) ) and going to (i + (j-1) + 1) = i+j th char in s3.
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        return helper(s1,s2,s3,0,0);
    }
    private boolean helper(String s1,String s2,String s3,int i,int j){
        int k = i+j;
        if(k==s3.length())return true;
        boolean ans = false;
        ans |= i<s1.length() && s1.charAt(i)==s3.charAt(k) && helper(s1,s2,s3,i+1,j);
        ans |= j<s2.length() && s2.charAt(j)==s3.charAt(k) && helper(s1,s2,s3,i,j+1);
        return ans;
    }
}
// memoization of above recursive code with ,time and space complexity : O(nm)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())return false;
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return helper(s1,s2,s3,0,0,dp);
    }
    private boolean helper(String s1,String s2,String s3,int i,int j,int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j]==1;
        int k = i+j;
        if(k==s3.length())return true;
        boolean ans = false;
        ans |= i<s1.length() && s1.charAt(i)==s3.charAt(k) && helper(s1,s2,s3,i+1,j,dp);
        ans |= j<s2.length() && s2.charAt(j)==s3.charAt(k) && helper(s1,s2,s3,i,j+1,dp);
        dp[i][j] = ans?1:0;
        return ans;
    }
}
