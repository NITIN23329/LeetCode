/*
    approach:
      --> for a dice roll, we can get 1 to 6. So we will take all 6 possibilities of a dice roll.
      --> so if n==0, we have no futher rolls hence return 1.
      --> as for a particular i in 1 to 6, we can get i only at max rollMax[i] times consecutively, so we will keeptrack of previously rolled face and its count
      --> if in our current roll, we get same face as of previous and we have consecutive count of this face <= rollMax then only we continue to simulate game futher.
      --> otherwise if our current face is not previoius face, we reset our face to current face and count to 1 and simulate game furthur.
*/
class Solution {
    int mod = (int)1e9+7;
    public int dieSimulator(int n, int[] rollMax) {
        return (int)helper(n,rollMax,6,0);
    }
    private long helper(int n, int[] rollMax,int prev,int count){
        if(n==0)return 1;
        long c = 0;
        for(int i=0;i<6;i++)
            if(prev==i && count+1<=rollMax[i])
                c = (c + helper(n-1,rollMax,prev,count+1))%mod;
            else if(prev!=i)
                c = (c + helper(n-1,rollMax,i,1))%mod;
        return c;
    }
}
// time and space complexity : O(n * 7 * 16) = O(n)
class Solution {
    int mod = (int)1e9+7;
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp = new long[n+1][7][16];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=6;j++)
                Arrays.fill(dp[i][j],-1);
        return (int)helper(n,rollMax,6,0,dp);
    }
    private long helper(int n, int[] rollMax,int prev,int count,long[][][] dp){
        if(n==0)return 1;
        if(dp[n][prev][count]!=-1)return dp[n][prev][count];
        long c = 0;
        for(int i=0;i<6;i++)
            if(prev==i && count+1<=rollMax[i])
                c += helper(n-1,rollMax,prev,count+1,dp);
            else if(prev!=i)
                c += helper(n-1,rollMax,i,1,dp);
        return dp[n][prev][count] = c % mod;
    }
}
