// approach 1 : using knapsack with time and space complexity O(n^2)
/*
  approach. :
    --> It is always better to cook less satisfaction level dish when time is small and keep high  satisfaction level dish for greater time.
    --> So we sort dishes in increasing order of satisfaction level.
    --> Then we have 2 choices for each dish, either to cook it or to leave it.
            --> If we cook it, we get time * arr[i] as Like time coefficient and timesbecomes time + 1 after cooking.
            --> If we dont cook it, we dont increment time but goto next dish.
    --> return maximum of both cases.
*/
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int[][] dp = new int[n][n+1];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return helper(0,1,satisfaction,dp);
    }
    private int helper(int i,int time,int[] satisfaction,int[][] dp){
        if(i==satisfaction.length)return 0;
        if(dp[i][time]!=-1)return dp[i][time];
        int c1 = time * satisfaction[i] + helper(i+1,time+1,satisfaction,dp);
        int c2 = helper(i+1,time,satisfaction,dp);
        return dp[i][time] = Math.max(c1,c2);
    }
}
// approach 2 : a greedy with time complexity : O(nlogn)
/*
    approach :
        --> It is for sure that we will always cook those dishes whose satisfaction level >= 0 
        --> question arrises when to cook dishes with -ve satisfaction level?
        --> We are happy to cook -ve satisfaction level dishes as long as we get more Like time coefficient.
        --> So we will keep hold of suffix . This helps to get Like time coefficient of all dishes from i-1 to n-1 using Like time coefficient of all dishes from i to n-1.
        --> Like time coefficient upto index n-1 is arr[n-1] ,upto index n-2 is arr[n-1] + arr[n-2] + arr[n-1] ,upto index n-3 is arr[n-1] + arr[n-2] + arr[n-1] + arr[n-3] + arr[n-2] + arr[n-1].
        --> like time cofficient  i to n-1 = suffix of n-1 to i + time cofficient  i+1 to n-1
*/
class Solution {
    public int maxSatisfaction(int[] arr) {
        // sort the arrays on increasing order of satisfaction level.
        Arrays.sort(arr);
        int suffix = 0;     // stores suffix sum upto index i
        int curr = 0;       // storesLike time coefficient upto index i
        int res = 0;         // stores Like time coefficient upto index i-1
        for(int i =arr.length-1;i>=0;i--){
            suffix+=arr[i];
            curr= suffix + res;
            if(curr<res)break;
            res = curr;
        }
        return res;
    }
}
