// time complexity : O(n*n*fuel) and space complexity : o(n*fuel)
/*
  approach :
    --> for every location , we can goto i th city from start iff abs(locations[i] - locations[start])<=fuel. If we are out of fuel(<0), we can not move further.
    --> if we have reached our destination we found a valid path . Although we dont stop here, we continue to move untill we are out of fuel.
*/
class Solution {
    int mod = (int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel+1];
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i],-1);
        return (int)helper(locations,start,finish,fuel,dp);
    }
    private long helper(int[] locations,int start,int finish,int fuel,long[][] dp){
        if(fuel<0)return 0;
        if(dp[start][fuel]!=-1)return dp[start][fuel];
        long ans = start==finish?1:0;
        for(int i=0;i<locations.length;i++)
            if(start!=i)
                ans+= helper(locations,i,finish,fuel - Math.abs(locations[i]-locations[start]),dp);
        return dp[start][fuel] = ans%mod;
    }
}
