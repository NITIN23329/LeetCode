// memoizatation with time and space complexity : O(n^2)
/*
  approach :
    1) n==1 we return 0
    2) if n>1
      1) it is sure that we will copy the First A and paste it in notepad. 2 operations
      2) after doing it we have 2 choices if we are at i,
        1) if i + i <=n then we can copy and paste entire notepad which take 2 operations
        2) if i + copy <=n then we can only paste which tack 1 operations.
        3) otherwise it is not possible to reach n from i with current copy size.
*/
class Solution {
    public int minSteps(int n) {
        if(n==1)return 0;           // corner case , n==1 return 0
        // otherwise it is sure that we will copy first A and Paste it .So notepad has AA initially, which requires 2 operations.
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        return 2 + helper(1,2,n,dp);
    }
    private int helper(int copy,int i,int n,int[][] dp){
        if(i==n)return 0;
        if(dp[i][copy]!=-1)return dp[i][copy];
        if(2*i<=n)                  // when we can copy entire string from notepad
            return dp[i][copy] = Math.min(2+helper(i,2*i,n,dp), 1+helper(copy,i+copy,n,dp));
        if(i+copy<=n)               // when we will use previously copied string
            return dp[i][copy] = 1+ helper(copy,i+copy,n,dp);
        return dp[i][copy] = 10000;       // not possible with current copy size
    }
    
}
// another faster dp solution.
// time complexity :  O( n + n/2 * n/2) = O(n^2), space compelxity O(n)
/*
  approach : observe some pattern :
  1 => 0
  2 => 2
  3 => 3
  4 => 4
  5 => 5
  6 => 5
  7 => 7
  8 => 6
  9 => 6
  10 => 7
  11 => 11
  12 => 7
  13 => 13
  14 => 9
  15 => 8
  it is observable that if n is even , n%2==0 , say 12 , we will copy 6 A's and paste them. Hence ans of n = 2 + ans of n/2.
  if n%2==1
    if n is a prime number , ans of n = n
    else ans of n = min ( ans of i + ans of j) such that i*j = n. Say n=15 which has one divisor 3 and 5 , ans of 15 = ans of 3 + ans of 5 = 3 + 5 = 8.
  
  
*/

class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            if(i%2==0)dp[i] = 2 + dp[i/2];
            else {
                dp[i] = i;
                for(int j=1;j<i/2;j++)
                    if(i%j==0)
                        dp[i] = Math.min(dp[i],dp[j]+dp[i/j]);
            }
        }
        return dp[n];
    }
    
}
