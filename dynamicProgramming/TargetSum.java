public class TargetSum {
    // recursive solution , time complexity O(2^n)
    // fore every element in nums ,either add to current sum or subtract it from current sum
    public int recursive(int[] nums, int S) {
        return recursiveHelpr(0,0,S,nums);
    }
    private int recursiveHelpr(int i,int curr,int sum,int[] arr){
        if(i==arr.length)return curr == sum ? 1 : 0;
        return recursiveHelpr(i+1,curr+arr[i],sum,arr) + recursiveHelpr(i+1,curr-arr[i],sum,arr);
    }
    // memoization of above recursive approach , time complexity O(2*n*sum)
    /*
        --> since the current sum can in in range -sum to +sum , where sum is atmax 1000
        --> create a dp array of [n][2*sum+1] size.
        --> for i and curr , store its answer in i and curr+1000 th index to be safe from negative index.
     */
    public int memoization(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return memoHelpr(0,0,S,nums,dp);
    }
    private int memoHelpr(int i,int curr,int sum,int[] arr,int [][] dp){
        if(i==arr.length)return curr == sum ? 1 : 0;
        if(dp[i][curr+1000]!=-1) return dp[i][curr+1000];
        return dp[i][curr+1000] = memoHelpr(i+1,curr+arr[i],sum,arr,dp) + memoHelpr(i+1,curr-arr[i],sum,arr,dp);
    }
}
