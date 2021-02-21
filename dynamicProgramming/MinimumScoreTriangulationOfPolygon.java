// time complexity : O(n^3) and space compoexity O(n^2)
// do a dry run for a [3,4,2,1,5] and find out all possible triangulation using MCM 
class Solution {
    public int minScoreTriangulation(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return memoHelper(arr,1,arr.length-1,dp);
    }
    private int memoHelper(int[] arr,int l,int r,int[][] dp){
        if(l==r)
            return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        int ans = Integer.MAX_VALUE;
        for(int k=l;k<r;k++){
            int left = memoHelper(arr,l,k,dp);
            int right  = memoHelper(arr,k+1,r,dp);
            int curr = left+right+arr[l-1]*arr[k]*arr[r];
            ans = Math.min(ans,curr);
        }
        return dp[l][r] = ans;
    }
}
