// time  and space compexity O(n*m)
/*  approach 1 :
      --> find length of longest common subsequence of s and t
      --> if it comes out to be s.length() return true else false.
*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        return s.length()==lcs(s,t);
    }
    private int lcs(String s1,String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0;i<s1.length();i++)
            Arrays.fill(dp[i],-1);
        return memoHelper(s1,s2,0,0,dp);
    }
    private int memoHelper(String s1,String s2,int i,int j,int[][] dp){
        if(i==s1.length() || j==s2.length())
            return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j] = 1 + memoHelper(s1,s2,i+1,j+1,dp);
        return dp[i][j] = Math.max(memoHelper(s1,s2,i+1,j,dp),memoHelper(s1,s2,i,j+1,dp));
    }
}
// time compexity O(m+n) , space complexity O(1)
/*  approach 2 : linearly search for all characters of s in t
    --> we need 2 pointers(n and m) , 1 for character in s and other for characters in t
    --> if s[n]==t[m] , n+=1 , m+=1
    --> else m+=1
    --> if we can find all characters of s in t we return true else false.
*/
class Solution {
    public boolean isSubsequence(String s, String t) {
        int n=0,m=0;
        while(n<s.length() && m<t.length()){
            if(s.charAt(n)==t.charAt(m)){
                n++;m++;
            }else m++;
        }
        return n==s.length();
    }
}
