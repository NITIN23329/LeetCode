// recursive solution
/*
  approach :
      --> we will keep hold of 2 things , # of current orders which are picked but not delivered yet(curr) and # of delivied orders(done)
      --> if the curr + done < n , then it means we have n - curr- done orders to be picked , we can pick any 1 of them at a time.
      --> if curr>0 then it means we have curr orders out of which 1 at a time can be delivered.
      -->base case , done == n, we are done delivering all n orders so return 1(we got a valid sequence of pick and deliver)
*/
class Solution {
    int mod = (int)1e9+7;
    public int countOrders(int n) {
        return (int)helper(0,0,n);
    }
    private long helper(int curr,int done,int n){
        if(done==n)return 1L;
        long ans = 0L;
        if(curr+done<n)ans  = (ans + (n-curr-done)*helper(curr+1,done,n))%mod;
        if(curr>0)ans  =  (ans + curr*helper(curr-1,done+1,n))%mod;
        return ans;
    }
}
// memoization of above recursive solution
// time and space complexity : O(n^2)
class Solution {
    int mod = (int)1e9+7;
    public int countOrders(int n) {
        long[][] dp = new long[n+1][n+1];
        for(int i=0;i<=n;i++)
            Arrays.fill(dp[i],-1);
        return (int)helper(0,0,n,dp);
    }
    private long helper(int curr,int done,int n,long[][] dp){
        if(done==n)return 1L;
        if(dp[curr][done]!=-1)return dp[curr][done];
        long ans = 0L;
        if(curr+done<n)ans  = (ans + (n-curr-done)*helper(curr+1,done,n,dp))%mod;
        if(curr>0)ans  =  (ans + curr*helper(curr-1,done+1,n,dp))%mod;
        return dp[curr][done] = ans;
    }
}
// another approach with time and space complexity : O(N)
/*
  1)suppose we already found answer for n=1 , now we will try to place the 2nd order in the sequence for n=1 and find answer for n=2 from n=1
  2) The only valid permutation for n=1 is _ P1 _ D1 _.
  3) now we will try to place P2 and D2 in between them.
  4) 6 possible permutations are : P2 D2 P1 _ D1 _ , P2 P1 D2 D1 _ , P2 P1 _ D1 D2 , _ P1 P2 D2 D1_ , _ P1 P2 D1 D2 , _ P1 _ D1 P2 D2.
  5) how we will got permutations as 6? look we had already placed n-1 items , so we have 2*n-1 spaces present btw Ps and Ds where we can add Pn and Dn
  6) suppose we have x gaps , so permutations if we use 1st gap as Pn is x , permutations if we use 2nd gap as Pn is x-1 , permutations if we use 3rd gap as Pn is x-2...... permutations if we use xth gap as Pn is x-x+1 = 1
  7) if we sum all those permutations, we get total permutations to put Pn and Dn, hence which is (x)*(x-1)/2 = (2n-1)*(2n)/2
  8) This is when we considered only 1 out of all valid sequence of n-1 orders , and for every valid sequence of n-1 orders, we do this.
  9) So the final total # of valid sequence to deliver n orders =  ( # of valid sequence to deliver n-1 orders ) * ( total permutations of put nth P and D in any valid sequence of n-1 orders)
*/
class Solution {
    public int countOrders(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1L;
        int mod = (int)1e9+7;
        for(int i=2;i<=n;i++){
            long permutations_to_place_ith = (2l*i)*(2l*i-1)/2L;
            dp[i] = (dp[i-1] * permutations_to_place_ith)%mod;
        }
        return (int)dp[n];
    }
}
