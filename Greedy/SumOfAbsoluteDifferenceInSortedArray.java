// time and space complexity : O(n)
/*
  approach :
    --> As we need to find sum(|nums[i] - nums[j]|), we know that all elements to right of i are >= nums[i] and all elements to left of i are <=nums[i]
    --> So nums[j] - nums[j] >=0 if j>i and nums[j] - nums[i] <=0 if j<i. or we can take nums[i] -  nums[j]>=0 for j<i.
    --> Let sum[i] = a[i] + b[i], where a[i] is the total contribution of all right element of nums[i] and b[i] is the total contribution from left elements of nums[i].
    --> So we can find right suffix sum  - # of element to right of i * nums[i] to be b[i].
    --> Similary we can find # of element to left of i * nums[i] - left suffix sum to get a[i].
*/
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] suffixSum = new int[n+1];
        int sum = 0;
        for(int i=n-1;i>=0;i--){
            suffixSum[i] = sum;
            sum+=nums[i];
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int rightSum = suffixSum[i];
            int leftSum = sum - suffixSum[i] - nums[i];
            int rightCount = n-i-1;
            int leftCount = n-rightCount-1;
            ans[i] = rightSum - rightCount * nums[i];
            ans[i] += leftCount * nums[i] - leftSum;
        }
        return ans;
    }
}
