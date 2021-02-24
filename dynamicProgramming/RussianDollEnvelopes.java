// # this is a variation of LIS
// time and space complexity O(nlogn + n^2)
// memoization solution
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->(a[0]-b[0]));
        int[][] dp = new  int[envelopes.length][envelopes.length];
        for(int i=0;i<envelopes.length;i++)Arrays.fill(dp[i],-1);
        return memoHelper(envelopes,-1,0,dp);
    }
    private int memoHelper(int[][] envelopes,int previ,int curri,int[][] dp){
        if(curri==envelopes.length)return 0;
        if(dp[curri][previ+1]!=-1)return dp[curri][previ+1];
        if(previ==-1 || (envelopes[curri][0] > envelopes[previ][0] && envelopes[curri][1] > envelopes[previ][1]))
            return  dp[curri][previ+1] = Math.max(1+ memoHelper(envelopes,curri,curri+1,dp), memoHelper(envelopes,previ,curri+1,dp));
        return  dp[curri][previ+1] = memoHelper(envelopes,previ,curri+1,dp);
    }
}
// time complexity O(n^2) and space complexity O(n)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->(a[0]-b[0]));
        int n = envelopes.length;
        int[] dp = new  int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++)
                if(envelopes[i][0]>envelopes[j][0] && envelopes[i][1]>envelopes[j][1])
                    dp[i] = Math.max(dp[i],1+dp[j]);
            max = Math.max(max,dp[i]);
        }
        return max;    
    }
}
