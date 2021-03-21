// time complexity : O(n^2)
/*
  approach :
    --> if we are at point stone[i], and we previously did  k jumps, we can goto point stones[i]+k or stones[i]+k+1 or stones[i]+k-1,
    --> since stones[i] can be very large(2^31), moving in them gives TLE. So instead of points we will use index.
    --> if we are at i and if we jump k then stones[i]+k must be present in the array other wise frog will fall in water.
    --> So create a map which tells the index in array by giving it a point.
    --> So if we are at index i and if stone[i]+k is also present in map, then we can make a jump and goto index of stone[i]+k by map.get(stone[i]+k).
    --> Similar arguments can be done for k-1 and k+1 jumps.
    
*/
class Solution {
    public boolean canCross(int[] stones) {
        if(stones[1]!=1)return false;
        Map<Integer,Integer> map = new HashMap<>();
        int n = stones.length;
        for(int i=0;i<n;i++)
            map.put(stones[i],i);
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return helper(stones,1,1,map,dp);
    }
    private boolean helper(int[] stones,int k,int i,Map<Integer,Integer> map,int[][] dp){
        if(i==stones.length-1)return true;
        if(dp[i][k]!=-1)return dp[i][k]==1;
        boolean ans = false;
        if(map.containsKey(stones[i]+k))
            ans |= helper(stones,k,map.get(stones[i]+k),map,dp);
        if(map.containsKey(stones[i]+k+1))
            ans |= helper(stones,k+1,map.get(stones[i]+k+1),map,dp);
        if(k-1>0 && map.containsKey(stones[i]+k-1))
            ans |= helper(stones,k-1,map.get(stones[i]+k-1),map,dp);
        dp[i][k] = ans? 1 : 0;
        return ans;
    }
}
