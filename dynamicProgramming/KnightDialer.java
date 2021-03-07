// time and space complexity = O(10n) = O(n)
/*  
    --> start from every start point (0,1,2,....,9)
    --> find # of ways to travel exactly n-1 times from that start point.
    --> add all them up and return .
*/
class Solution {
    int mod = ((int)1e9+7);
    public int knightDialer(int n) {
        int[][] moves = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        long ans = 0L;
        long[][] dp = new long[10][n];
        for(int i=0;i<10;i++)Arrays.fill(dp[i],-1);
        for(int start=0;start<=9;start++)
            ans = (ans + memoHelper(moves,start,n-1,dp))%mod;
        return (int)ans;
    }
    private long memoHelper(int[][] moves,int curr,int steps,long[][] dp){
        if(steps==0)return 1;
        if(dp[curr][steps]!=-1)return dp[curr][steps];
        long ans = 0L;
        for(int next : moves[curr])
              ans = (ans + memoHelper(moves,next,steps-1,dp))%mod;
        return dp[curr][steps] = ans;
    }
}
