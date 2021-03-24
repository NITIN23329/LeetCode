// time complexity : O(n^2) , space complexity O (n)
/*
  approach :
      --> suppose we are at index i and we need to find the LIS length such that our subsequene ends with element nums[i]
      --> so what elemenst we can take in this sequence? . a value arr[j] smaller than nums[i] and j<i can be added surely.
      --> so for i in rangle 0 to i-1,
          --> if nums[j] < nums[i], we can extend the subsequence ending at nums[j] by appending nums[i] to it.
          --> hence dp[i] = 1 + dp[j] , and find maximum for all j.
      --> take max for all i and return .
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int maxLen = 1;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++)
                if(nums[i]>nums[j])
                    dp[i] = Math.max(dp[i],1 + dp[j]);
            maxLen = Math.max(maxLen,dp[i]);
        }
        return maxLen;
    }
}
