// time complexity O(n*target) and space complexity O(target)
/*
  approach :
    --> since we are asked to find diierent permutatuions of sum , 
    --> we will try our every possible permuations
    --> we will consider every element from nums aslong as target>=nums[i]
 */
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return memoHelper(nums,target,dp);
    }
    private int memoHelper(int[] arr,int sum,int[] dp){
        if(sum==0)return 1;
        if(dp[sum]!=-1)return dp[sum];
        int ans = 0;
        for(int ele : arr)
            if(sum>=ele)
                ans+=memoHelper(arr,sum-ele,dp);
        return dp[sum] = ans;
    }
}
