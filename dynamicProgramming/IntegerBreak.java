// recursive solution with time complexity : O(N*(2^N))
/*
    approach :
        --> let say for a number n = x + y, we have 4 possible answers
        --> ans 1 = x * y
        --> ans 2  = split(x) * y
        --> ans 3 = x * split(y)
        --> ans 4 = split(x) * split(y)
        --> we return max of all 4 cases.
*/
class Solution {
    public int integerBreak(int n) {
        return recursiveHelper(n);
    }
    private int recursiveHelper(int n){
        if(n==1)return 1;
        int ans = 0;
        for(int i=1;i<n;i++){
            int x = recursiveHelper(i);
            int y = recursiveHelper(n-i);
            int c1 = i*(n-i);
            int c2 =  x * (n-i);
            int c3 = i * y;
            int c4 = x * y;
            ans = Math.max(ans,Math.max(Math.max(c1,c2),Math.max(c3,c4)));
        }
        return ans;
    }
}
// time complexity : O(n^2) and space complexityn O(n)
// meoization of above recursive solutions
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return memoHelper(n,dp);
    }
    private int memoHelper(int n,int[] dp){
        if(n==1)return 1;
        if(dp[n]!=-1)return dp[n];
        int ans = 0;
        for(int i=1;i<n;i++){
            int x = memoHelper(i,dp);
            int y = memoHelper(n-i,dp);
            int c1 = i*(n-i);
            int c2 =  x * (n-i);
            int c3 = i * y;
            int c4 = x * y;
            ans = Math.max(ans,Math.max(Math.max(c1,c2),Math.max(c3,c4)));
        }
        return dp[n] = ans;
    }
}
