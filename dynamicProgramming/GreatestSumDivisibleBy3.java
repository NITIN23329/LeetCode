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
