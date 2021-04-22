// time complexity : O(nlogn), space complexity : O(max(requests))
/*
  --> Since we need to maximize our sum, we try to put the max value in that index whose request is more, so that it will be added as many times as possbile.
  --> Using prefix array technique, the the request for each index.
  --> Then sort prefix[] and nums[] 
  --> And assign highest value in nums to highest value in prefix[] untill there are requests
*/
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int maxIndex = 0;
        for(int[] ele : requests)
            maxIndex = Math.max(maxIndex,Math.max(ele[0],ele[1]));
        long[] prefix = new long[maxIndex+2];
        for(int[] ele : requests){
            prefix[ele[0]]++;
            prefix[ele[1]+1]--;
        }
        for(int i=1;i<prefix.length;i++)
             prefix[i] += prefix[i-1];
        Arrays.sort(prefix);
        Arrays.sort(nums);
        long sum = 0;
        int mod = (int)1e9+7;
        int i = nums.length-1;
        int last = prefix.length-1;
        while(last>=0 && prefix[last]>0){
            sum += (prefix[last--] * nums[i--]);
            sum %=mod;
        }
        return (int)sum;
    }
}
