/*  memoization with time and space complexity O(N^2)
    --> we sort the pairs according to ele[1] as we can take pairs in any order, so we will put smaller ele[1] pairs before larger ele[1] pairs to increase our possibility to get larger length.
    --> if for any i and j, pair[i][0] > pair[j][1] , we have 2 choices , either we can take pair[i] to our current subsequence or skip pair[i] and check from next i
    --> if pair[i][0] <=pair[j][1] we can only have 1 option to skip pair[i] 
*/
class Solution {
    public int findLongestChain(int[][] pair) {
        Arrays.sort(pair,(a,b)->(a[1]-b[1]));
        int[][] dp = new int[pair.length+1][pair.length+1];
        for(int i=0;i<=pair.length;i++)Arrays.fill(dp[i],-1);
        return memoHelper(pair,0,-1,dp);
    }
    private int memoHelper(int[][] pair,int curr,int prev,int[][] dp){
        if(curr==pair.length)return 0;
        if(dp[curr][prev+1]!=-1)return dp[curr][prev+1];
        if(prev==-1 || pair[curr][0]>pair[prev][1])
            return  dp[curr][prev+1] = Math.max(1+memoHelper(pair,curr+1,curr,dp),
                                                memoHelper(pair,curr+1,prev,dp));
        return  dp[curr][prev+1] = memoHelper(pair,curr+1,prev,dp);
    }
}
// bottom up with time complexity : O(n^2) and space complexity O(n)
class Solution {
    public int findLongestChain(int[][] pair) {
        Arrays.sort(pair,(a,b)->(a[1]-b[1]));
        int max = 0;
        int[] dp = new int[pair.length];
        for(int i=0;i<pair.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++)
                if(pair[i][0]>pair[j][1])
                    dp[i] = Math.max(dp[i],1 + dp[j]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
   
}
