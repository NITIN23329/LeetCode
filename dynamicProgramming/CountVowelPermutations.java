// time and space complexity : O(6n)
// if we know the previously used vowel, we can choose our current vowel based on condition. And thats what we only do.
class Solution {
    int mod = (int)1e9+7;
    public int countVowelPermutation(int n) {
        long[][] dp = new long[n][6];
        for(int i=0;i<n;i++)dp[i] = new long[]{-1,-1,-1,-1,-1,-1};
        return (int)helper(0,0,n,dp);
    }
    private long helper(int i,int prev,int n,long[][] dp){
        if(i==n)return 1;
        if(dp[i][prev]!=-1)return dp[i][prev];
        long ans = 0;
        if(prev==0 || prev==3)
            for(int curr=1;curr<=5;curr++){
                if(prev==3 && curr==3)continue;
                ans += helper(i+1,curr,n,dp);
            } 
         else if(prev==1)
            ans += helper(i+1,2,n,dp);
         else if(prev==2)
            ans += helper(i+1,1,n,dp) + helper(i+1,3,n,dp);
         else if(prev == 4)
            ans += helper(i+1,3,n,dp) + helper(i+1,5,n,dp);
         else if(prev == 5)
            ans += helper(i+1,1,n,dp);
        return dp[i][prev] = ans%mod;
    }
}
