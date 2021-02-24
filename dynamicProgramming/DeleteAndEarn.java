// time and space complexity O(n) , where n = 10000
/*
  apporach : this problem is somewhat similar to maximum sum with no 2 consecutive elements
      --> consider we are at value x , the next value we can take in x+2
      --> or we can take value at x-1 and make it as value of x
      --> there are 2 choices available , either take x-2 sum and add x to it or take x-1 sum only
      --> as duplicates are available , we find total sum of each x in 1 to 10000 and store it in arr[]
      --> then for every i in 1 to 10000 , we have 2 choices
      --> either take sum upto i-2 and add current i to it
      --> or we can take sum upto i-1 to it.
      --> we will take max of both cases
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for(int ele : nums)arr[ele]+=ele;
        int[] dp = new int[10001];
        dp[1] = arr[1];
        for(int i=2;i<arr.length;i++)
            dp[i] = Math.max(dp[i-2]+arr[i],dp[i-1]);
        return dp[10000];
    }
}
