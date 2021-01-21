// recursive solution time compleixty O(sqrt(n) * 2^(sqrt(n))
/*  approach :
        --> take every case from i = 1 to sqrt(n) , find result for n-i*i , add 1 to it . this will give result for n
        --> find min of above step and return it.
        --> base case is when n==0 return 0. 
*/
class Solution {
    public int numSquares(int n) {
        return helpr(n);
    }
    private int helpr(int n){
        if(n==0)return 0;
        int res = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++)
            res = Math.min(res, 1 + helpr(n-i*i));
        return res;
    }
}
// time complexity O(n* sqrt(n))
// do the memomization of above approach
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helpr( n, dp);
    }
    private int helpr(int n,int[] dp){
        if(n==0)return 0;
        int res = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
             if(dp[n-i*i]==-1)
                    dp[n-i*i]= Math.min(res, 1 + helpr(n-i*i,dp));
             res = Math.min(res,dp[n-i*i]);
        }
        return res;
    }
}
