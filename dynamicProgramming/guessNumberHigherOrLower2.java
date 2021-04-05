// time complexity : O(n^3), space complexity : O(n^2)
/*
  approach : This problem is very much similar to egg dropping problem.
  --> for all k in range(l,r+1), assume we guessed k and it is wrong. So we goto either left(l,k-1) or right(k+1,r) depending upon what the other guy tells us.
  --> Since we can go either left or right, In worst case we goto that segment which gives us high cost. So we need to consider max of it.
  --> So a temporary ans = k + max(left,right). Out of all temporary answer we take minimum one.
*/
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return helper(1,n,dp);
    }
    private int helper(int l,int r,int[][] dp){
        if(l>=r)return 0;
        if(dp[l][r]!=0)return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int k=l;k<=r;k++){
            int curr = k + Math.max(helper(l,k-1,dp),helper(k+1,r,dp));
            ans = Math.min(curr,ans);
        }
        return dp[l][r] = ans;
    }
}
