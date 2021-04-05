// time complexity : O(n), space complexity : O(1)
/*    
  --> Consider an example: [1,2,3,4,5,6],n = 6.
  --> suppose we have a arithmatic subsequence of length n, how many arithmetic subarrays we can have from the given sequence?
      --> # of arithmantic subarrays of length 3 = n - 3 + 1 ( [1,2,3],[2,3,4],[3,4,5],[4,5,6] )
      --> # of arithmantic subarrays of length 4 = n - 4 + 1 ( [1,2,3,4] , [2,3,4,5], [3,4,5,6] )
            .               .               .
            .               .               .
            .               .               .
      --> # of arithmantic subarrays of length n = n - n + 1 ( [1,2,3,4,5,6] )
      --> to get all arithmartic subarrays, we will add # of arithmantic subarrays of length 3,4,5....n
      --> total arithmartic subarrays = (n - 3 + 1) + (n - 4 + 1) + (n - 5 + 1) ... (n - n + 1) = (n+1) * (n-2) + (n) * (n+1)/2 + 3.
      --> Let currLen denotes the length of a arithmatic subarray having difference diff.
      --> If nums[i] - nums[i-1] == diff, we increment our currLen.
      --> If we found nums[i] - nums[i-1] != diff. it means out current arithmatic subarray ends at element i-1.
      --> we add total arithmartic subarrays and we reassign our diff = nums[i] - nums[i-1] and assign currLen = 2. Why 2?
      --> Take an example [1,3,5,4,3], Here we can make 2 different subbarays [1,3,5] and [5,4,3]. See that 5 is included in both subarrays.
*/
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int diff = 10_000;
        int currLen = 0;
        int ans = 0;
        for(int i=1;i<n;i++){
            if(diff==nums[i] - nums[i-1])currLen++;
            else {
                diff = nums[i] - nums[i-1];
                ans += countArithmaticSubarrays(currLen);
                currLen = 2;
            }
        }
        ans += countArithmaticSubarrays(currLen);
        return ans;
    }
    private int countArithmaticSubarrays(int len){
        return len>=3?(len+1)*(len-2) - (len)*(len+1)/2 + 3:0;
    }
}
