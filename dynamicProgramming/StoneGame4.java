// recursive code
/*
  approach : is simple
  --> let say chance is of alice, she can take any perfect square in range 1 to n.
  --> ley say she choose a perfect number x.
  --> now bob will get to choose from n-x.
  --> if bob wins , alice loose and if bob fails , alice wins => alice = !bob and bob = !alice
  --> so we will recursively call for n-x and we toggle the recursive result we get to get winning status of current player.
*/  
class Solution {
    public boolean winnerSquareGame(int n) {
        return helper(n);
    }
    private boolean helper(int n){
        if(n==0)return false;
        boolean ans = false;
        for(int i=1;i*i<=n;i++)
            ans = ans || !helper(n-i*i);
        return ans;
    }
}
// memoization of above recursive solution 
// time complexity O(n*sqrt(n)) and space complexity O(n)
class Solution {
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    private boolean helper(int n,int[] dp){
        if(n==0)return false;
        if(dp[n]!=-1)return dp[n] == 1;
        boolean ans = false;
        for(int i=1;i*i<=n;i++)
            ans = ans || !helper(n-i*i,dp);
        dp[n] = ans? 1 : 0;
        return ans;
    }
}
// bottom up dp with time compelexity O(n*sqrt(n)) and space coompelxity O(n)
class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] wins = new boolean[n+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j*j<=i;j++)
                wins[i] = wins[i] || !wins[i-j*j];
        }
        return wins[n];
    }
}
