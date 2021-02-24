// time complexity :O(n) and space complexity O(1)
/*
    1.The last maximum possible sum that it is divisible by three could only depends
        on 3 kinds of "subroutines/subproblems":
            1. previous maximum possible sum that it is divisible by three
               preSum % 3 == 0       (example: preSum=12 if lastNum=3)
            2. preSum % 3 == 1       (example: preSum=13 if lastNum=2)
            3. preSum % 3 == 2       (example: preSum=14 if lastNum=1)
    2. This recusion + "subroutines" pattern hints Dynamic Programming
*/
class Solution {
    public int maxSumDivThree(int[] nums) {
      // this is a three element array where index 0 stores maximum sum which given a remainder 0 when divided by 0
      // index 1 stores max sum which gives a remainder 1 when divided by 3 and index 2 gives a remainder 2 when divides by 3
        int[] dp = new int[3];
        for(int i=0;i<nums.length;i++){
            // every time , we get 3 different combinations of numbers by adding nums[i] with dp[0],dp[1] and dp[2]
            // we stores this newly created combinations into their appropiate position.
            int a1 = dp[0]+nums[i];
            int a2 = dp[1]+nums[i];
            int a3 = dp[2]+nums[i];
            dp[a1%3] = Math.max(dp[a1%3],a1);
            dp[a2%3] = Math.max(dp[a2%3],a2);
            dp[a3%3] = Math.max(dp[a3%3],a3);
        }
        return dp[0];
    }
    
}
// recursive solution time and space O(n)
/*
   --> to find  longest sum when dividedy by 3 leaves remainder 0 , 1 and 2 for n, we will use the longest sum when dividedy by 3 leaves remainder 0 , 1 and 2 for n-1
   --> try out all possible combiantions of nums[i] with longest sum when dividedy by 3 leaves remainder 0 , 1 and 2 for n-1.
   --> if we don't find longest sum when dividedy by 3 leaves remainder 0 , 1 and 2  return -1
*/
class Solution {
    public int maxSumDivThree(int[] nums) {
        return Math.max(0,memoHelper(nums,0)[0]);
    }
    private int[] memoHelper(int[] nums,int i){
        if(i==nums.length)return new int[]{-1,-1,-1};
        int[] next = memoHelper(nums,i+1);
        int[] curr = new int[3];
        if(nums[i]%3==1){
            curr[1] = next[0]==-1 ? Math.max(next[1],nums[i]) : Math.max(next[1],next[0]+nums[i]);
            curr[0] = next[2]==-1 ? next[0] : Math.max(next[0],next[2]+nums[i]);
            curr[2] = next[1]==-1 ? next[2] : Math.max(next[2],next[1]+nums[i]);
        }
        else if(nums[i]%3==2){
            curr[2] = next[0]==-1? Math.max(next[2],nums[i]) : Math.max(next[2],next[0]+nums[i]);
            curr[1] = next[2]==-1? next[1] : Math.max(next[1],next[2]+nums[i]);
            curr[0] = next[1]==-1? next[0] : Math.max(next[0],next[1]+nums[i]);
        }
        else{
            curr[0] = next[0]==-1? nums[i] : next[0]+nums[i];
            curr[1] = next[1]==-1 ? -1 : next[1]+nums[i];
            curr[2] = next[2]==-1 ? -1 : next[2]+nums[i];
        }
        return curr;
    }
}
