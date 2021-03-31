// time complexity : O(n*m*k*m) and space complexity : O(n*m*m)
/*
   --> What does k reprsents, the # of elements greater that current element on right side of current element.
   --> if k==0, it means we can use only elemenets used uptil now 
   --> Otherwise we can use a new element which is greater than all elements used untill now.
   --> So we keep hold of maxTillNow, and we find all answers for maxTillNow to M and add it to get answer for current k.
   --> After finding all elements, if k==0 then it means we have met out requiremnet hence return 1
*/
class Solution {
    int mod = (int)1e9+7;
    public int numOfArrays(int n, int m, int k) {
        long[][][] dp = new long[n][m+1][k+1];
        for(int i=0;i<n;i++)
            for(int j=0;j<=m;j++)
                Arrays.fill(dp[i][j],-1);
        return (int)helper(0,0,n,m,k,dp);
    }
    private long helper(int index,int maxTillNow,int n,int m,int k,long[][][] dp){
        if(index==n)return k==0?1:0;
        if(dp[index][maxTillNow][k]!=-1)return dp[index][maxTillNow][k];
        long ans = 0;
        if(k==0)
            ans = maxTillNow * helper(index+1,maxTillNow,n,m,k,dp);
        else {
            ans = maxTillNow * helper(index+1,maxTillNow,n,m,k,dp);
            for(int max = maxTillNow+1;max<=m;max++)
                ans += helper(index+1,max,n,m,k-1,dp);
        }
        return dp[index][maxTillNow][k] = ans%mod;
    }
}
