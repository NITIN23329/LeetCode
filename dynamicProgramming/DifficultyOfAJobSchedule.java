// time complexity : O(n*n*d), and space complexity : O(n*d)
/*
  approach : partion of array approach
  --> suppose we are at job i, and we have d days left and each day we need to do atleast 1 job.
  --> So what is the window for current day? jobs from i to n-d can be done on day d and rest will be done in future
  --> So we consider all length subbarays starting from job i to jon n-d for d'th day and find min for all cases.
  --> base case if d==0 and we had n't reached to i==n, then some of jobs are left which is not a valid choice return max val = 10000.
*/
class Solution {
    public int minDifficulty(int[] arr, int d) {
        int n = arr.length;
        int[][] dp = new int[n+1][d+1];
        for(int i=0;i<=n;i++)Arrays.fill(dp[i],-1);
       return d>n? -1 : helper(arr,n,0,d,dp); 
    }
    private int helper(int[] arr,int n,int i,int d,int[][] dp){
        if(d==0){
            if(i==n)return dp[i][d] = 0;
            else return dp[i][d] = 10000;
        }
        if(dp[i][d]!=-1)return dp[i][d];
        int res = Integer.MAX_VALUE;
        int curr = 0;
        for(int x=i;x<=n-d;x++){
            curr = Math.max(curr,arr[x]);
            int choice = curr + helper(arr,n,x+1,d-1,dp);
            res = Math.min(res,choice);
        }
        return dp[i][d] = res;
    }
}
