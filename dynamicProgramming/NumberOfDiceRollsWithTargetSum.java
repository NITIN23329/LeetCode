//recursive code with time complexity 
/*  approach :
      --> we need to use all d dices and try to make their sum = target
      --> if we are able to do so return 1 else return 0
      --> so the base case is, if d==target==0 return 1 , else if d==0 and targetr !=0 return 0
      --> for current dth dice we will consider all possible faces from i = 1 to f and try to find sum of other d-1 dices as target-i
      --> we will find all posible combinations of such types
      
*/
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        return (int)recursiveHelper(d,f,target);
    }
    private long recursiveHelper(int d,int f,int target){
        if(d==0)
            if(target==0)return 1;
            else return 0;
        long ans = 0L;
        for(int i=1;i<=f;i++)
            if(target-i>=0)
                ans = (ans+recursiveHelper(d-1,f,target-i))%((int)1e9+7);
        return ans;
    }
}
// memoization of above recursive code
// time compelxity : O(d*f*target)
// space complexity : O(d*target)
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[d+1][target+1];
        for(int i=0;i<=d;i++)Arrays.fill(dp[i],-1);
        return (int)recursiveHelper(d,f,target,dp);
    }
    private long recursiveHelper(int d,int f,int target,long[][] dp){
        if(d==0)
            if(target==0)return 1;
            else return 0;
        if(dp[d][target]!=-1)return dp[d][target];
        long ans = 0L;
        for(int i=1;i<=f;i++)
            if(target-i>=0)
                ans = (ans+recursiveHelper(d-1,f,target-i,dp))%((int)1e9+7);
        return dp[d][target] = ans;
    }
}
