// time complexity : O(n) and space complexity : O(1)
// find maximum positive subarrays sum and maximum negative subarray sum using kadane's algorithm and return max magnitude out of them
class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxPos = 0;
        int currPos = 0;
        int maxNeg = 0;
        int currNeg = 0;
        for(var ele : nums){
            currPos = Math.max(ele,currPos+ele);
            maxPos = Math.max(maxPos,currPos);
            currNeg = Math.min(ele,currNeg+ele);
            maxNeg = Math.min(maxNeg,currNeg);
        }
        return Math.max(maxPos,-maxNeg);
    }
}
