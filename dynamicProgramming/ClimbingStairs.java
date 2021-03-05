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
// time and complexity O(n)
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
// time and space complexity O(1) , however space complexity ccan be reduced to O(1)
// bottom up dp
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[0] = 1;
        for(int i=2;i<=n;i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}
