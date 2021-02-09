// time complexity : O(2^n)
// recursive code
class Solution {
    public int climbStairs(int n) {
        return recursive(n);
    }
    private int recursive(int n){
        if(n==0)return 1;
        if(n<0)return 0;
        return recursive(n-1) + recursive(n-2);
    }
}
// time complexity O(n)
// memoization of above recursive code.
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoHelper(n,dp);
    }
    private int memoHelper(int n,int[] dp){
        if(n==0)return 1;
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        return dp[n] = memoHelper(n-1,dp) + memoHelper(n-2,dp);
    }
}
