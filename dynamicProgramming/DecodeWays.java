// time complexity O(2^n)
/*
  recursive approach :
    --> for every i in 0 to s.length()-1 , we have 2 choices,
    --> we can take s[i] only  as a single letter
    --> we take take (s[i]+s[i+1]) as a single letter if (s[i]+s[i+1]) <=26
    --> we find recursive answer for both choices
    --> if s[i]==0 , we return 0 as '0' or '06' etc are not valid combinations
*/
class Solution {
    public int numDecodings(String s) {
        return recursiveHelper(s,0);
    }
    private int recursiveHelper(String str,int i){
        if(i==str.length())
            return 1;
        if(str.charAt(i)=='0')
            return 0;
        int ans = 0;
        ans += recursiveHelper(str,i+1);
        if(i+1<str.length() && Integer.parseInt(str.substring(i,i+2))<=26)
           ans += recursiveHelper(str,i+2);
        return ans;
        
    }
}
// memoization of above recursive code with time and space complexity : (n)
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return memoHelper(s,0,dp);
    }
    private int memoHelper(String str,int i,int[] dp){
        if(i==str.length())
            return 1;
        if(str.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)return dp[i];
        int ans = 0;
        ans += memoHelper(str,i+1,dp);
        if(i+1<str.length() && Integer.parseInt(str.substring(i,i+2))<=26)
           ans += memoHelper(str,i+2,dp);
        return dp[i] =  ans;
        
    }
}
