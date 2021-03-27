// recursive code:
/*
  approach :    Simply Simulate the game.
      --> Suppose we are at index i, be it alice or bob, player have 3 options to choose
      --> either to pick arr[i] or arr[i] + arr[i+1] or arr[i] + arr[i+1] + arr[i+2] provided there are stones left .
      --> Based on current player choice, the next player will get to choose accordingly from next index of last picked index by current player.
      --> The strategy of bob is not to maximize his score but to reduce alice score. And alice startegy is to maximise her score.
      --> suppose alice picked only arr[i], then bob have 3 above choice also, to choose from 3 conscutive stones. Bob will choose such that the stone alice get in next move is mimumum.
      --> Similar goes if alice pick arr[i+1] or arr[i] or arr[i] + arr[i+1] + arr[i+2].
      --> Out of 3 available choices to alice, she will pick that which gives her  maximum stones.
      --> Let say we will find the maxmimum stones alice can pick, then bob stones = total stones - alice stones
      
*/
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int sum = 0;
        for(int ele : stoneValue)sum+=ele;
        int aliceScore = aliceHelper(stoneValue,0,stoneValue.length);
        int bobScore = sum - aliceScore;
        if(aliceScore>bobScore)return "Alice";
        if(aliceScore==bobScore)return "Tie";
        return "Bob";
    }
    private int aliceHelper(int[] arr,int i,int n){
        if(i>=n)return 0;
        int max = Integer.MIN_VALUE;
        int cumulative = 0;
        for(int x=i;x<Math.min(n,i+3);x++){
            cumulative+=arr[x];
            max = Math.max(max,cumulative + bobHelper(arr,x+1));
        }
        return max;
        
    }
    private int bobHelper(int[] arr,int i){
        int min = Integer.MAX_VALUE;
        for(int x = i;x<i+3;x++)
            min = Math.min(min,aliceHelper(arr,x+1,arr.length));
        return min;
    }
}
// memoization of above recursive code with time and space complexity : O(n)
class Solution {
    int[] dp;
    public String stoneGameIII(int[] stoneValue) {
        int sum = 0;
        for(int ele : stoneValue)sum+=ele;
        int n = stoneValue.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        int aliceScore = aliceHelper(stoneValue,0,n);
        int bobScore = sum - aliceScore;
        if(aliceScore>bobScore)return "Alice";
        if(aliceScore==bobScore)return "Tie";
        return "Bob";
    }
    private int aliceHelper(int[] arr,int i,int n){
        if(i>=n)return 0;
        if(dp[i]!=-1)return dp[i];
        int max = Integer.MIN_VALUE;
        int cumulative = 0;
        for(int x=i;x<Math.min(n,i+3);x++){
            cumulative+=arr[x];
            max = Math.max(max,cumulative + bobHelper(arr,x+1));
        }
        return dp[i] = max;
        
    }
    private int bobHelper(int[] arr,int i){
        int min = Integer.MAX_VALUE;
        for(int x = i;x<i+3;x++)
            min = Math.min(min,aliceHelper(arr,x+1,arr.length));
        return min;
    }
}
