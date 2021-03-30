// time complexity: O(n*n*m) , and space complexity : O(nm). We will get a TLE If m increases furthur, like m = 1000
/*
    --> Suppose we are at index i and we need to make m partitions, and each partitions must have atleast 1 element in it, how would you do that?
    --> Remember we are currently making our m'th subaarray and we need to make m-1 more subarrays later.
    --> Hence our current subarray can hold elements from i upto index n-m.
    --> after making current subarray, we take max sum of current and all next subarrays with will be created later.
    --> and we return min sum of all possible ways we can create our current m'th subarray.
    --> one base case is if m==1, then our current subarray will hold all elements upto n-1.
*/
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
        return helper(nums,n,0,m,dp);
    }
    private int helper(int[] nums,int n,int i,int m,int[][] dp){
        if(dp[i][m]!=-1)return dp[i][m];
        if(m==1){
            int sum = 0;
            while(i<n)sum+=nums[i++];
            return dp[i][m] =  sum;
        }
        int curr = 0;
        int min = Integer.MAX_VALUE;
        for(int x = i;x<=n-m;x++){
            curr+=nums[x];
            int choice = Math.max(curr,helper(nums,n,x+1,m-1,dp));
            min = Math.min(min,choice);
        }
        return dp[i][m] = min;
    }
}
