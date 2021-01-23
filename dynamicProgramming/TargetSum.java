// recusive solution O(2^n)
/*
  --> for every index, either we can add is to current sum or we can subtact it from current sum.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return find(0,0,S,nums);
    }
    private int find(int i,int curr,int sum,int[] nums){
        if(i==nums.length)
            return curr==sum? 1:0;
        return find(i+1,curr+nums[i],sum,nums)+find(i+1,curr-nums[i],sum,nums);
    }
}
// dp of above approach (memomisation) , time complexity O(n^2) we created array of size 1000*2000
/*
  --> as curr sum can be negative so out base index is 1000 not 0.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2000];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i],-1);
        return find(0,0,S,nums,dp);
    }
    private int find(int i,int curr,int sum,int[] nums,int[][] dp){
        if(i==nums.length)
            return curr==sum? 1:0;
       if(dp[i][curr+1000]==-1)
           dp[i][curr+1000] = find(i+1,curr+nums[i],sum,nums,dp)+
                        find(i+1,curr-nums[i],sum,nums,dp);
        return dp[i][curr+1000];
    }
}
