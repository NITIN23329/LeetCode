// time complexity O(n) , space complexity (1)
/*
  approach : 
  --> for every i , either we continue previous subarray or we can start a new subarray from i
  --> we will consider both choices and find maximum of it.
  --> Kadane algo
*/  
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0] ; 
        int maxSubArray = nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum+nums[i],nums[i]);
            maxSubArray  = Math.max(maxSubArray,sum);
        }
        return maxSubArray;
    }
}
