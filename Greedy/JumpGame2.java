// time complexity : O(n^2), space : O(1)
/*
  --> The approach is to jump at that index which can leads to maximum distance
  --> Suppose we are at index i, and nums[i] = 3, so we can goto index i+1, i+2 and i+3.
  --> We will jump to that index which leads to farthest point.
*/
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int i = 0;
        if(i==nums.length-1)return 0;
        while(i<nums.length){
            int next = i;
            int max = 0;
            for(int j=i;j<=i+nums[i];j++){
                if(j==nums.length-1)return jumps+1;
                if(nums[j]+j-i>max){
                    max = nums[j] + j-i;
                    next = j;
                }
            }
            jumps++;
            i = next;
        }
        return -1;
    }
}
// time complexity : O(n) , space complexity : O(1) same approach .
/*
  --> We find the maximum end point(nextMaxEnd) for our current range [start,currEnd]. When we reach currEnd, we make a jump to nextMaxEnd and increment our counter.
*/
class Solution {
    public int jump(int[] nums) {
        if(nums.length==1)return 0;
        int currEnd = nums[0];
        int start = 0;
        int nextMaxEnd = 0;
        int count = 0;
        while(start<=currEnd){
            if(start==nums.length-1)break;
            nextMaxEnd = Math.max(nextMaxEnd,nums[start]+start);
            if(start==currEnd){
                currEnd = nextMaxEnd;
                count++;
                nextMaxEnd = 0;
            }
            start++;
        }
        return count+1;
    }
}
