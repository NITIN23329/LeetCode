// time and space complexity : O(n) , however, space complexity can be reduced to O(1)
/*
    approach : this problem is similar to house robber 1 link : https://leetcode.com/problems/house-robber/
    --> one thing obvious is that if we rob house 0 , we cann't rob house n-1 and if we don't rob house 0 , we will rob house at n-1
    --> so first search space will be from 0 to n-2(excluding last house but including first house)
    --> and the second search space will be from 1 to n-1(including last house but excluding first house)
    --> we will return max of both cases
*/
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)return nums[0];
        return Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
    }
    private int helper(int[] nums,int l,int r){
        if(l==r)return nums[l];
        int[] dp = new int[nums.length];
        dp[l] = nums[l];
        dp[l+1] = Math.max(nums[l],nums[l+1]);
        for(int i=l+2;i<=r;i++)
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        return dp[r];
    }
}
