// problem link : https://leetcode.com/problems/coin-change/
import java.util.Arrays;

public class CoinChange {
    // recursive with time complexity O(amount^n)
    /*
        approach : this problem is similar to subset where sum = amount
            --> a minor difference is we can use a particular value any # of times like unbounded knapsack
            --> so for a particular coin we can
                    --> either reduce amount by current coin value and recursively call for this coin again
                    --> we ignore this coin and goto next coin.
                    -->in all possible cases ,check if it is possible to get given amount using minimum coins
            --> remember we can pick a coin as long as sum of all coins <= amount required.
     */
    public int recursive(int[] coins, int amount) {
        return memoHelper(0,amount,coins);
    }
    private int memoHelper(int i, int amount, int [] coins){
        if(amount==0)return 0;
        if(i==coins.length)return -1;
        int y = memoHelper(i+1,amount,coins);
        if(amount-coins[i]>=0){
            int x = memoHelper(i,amount-coins[i],coins);
            if(x==-1 && y==-1)return -1;
            if(x==-1)return y;
            if(y==-1)return 1 + x;
            return Math.min(1+x,y);
        }
        return y;
    }
    // time complexity O(n*amount) , we used -2 to initialize dp array with -2 cuz -1 represents that it is impossible to get given amount
    public int memoization(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
            Arrays.fill(dp[i],-2);
        return memoHelper(0,amount,coins,dp);
    }
    private int memoHelper(int i, int amount, int [] coins, int[][] dp){
        if(amount==0)return 0;
        if(i==coins.length)return -1;
        if(dp[i][amount]!=-2)return dp[i][amount];
        int y = memoHelper(i+1,amount,coins,dp);
        if(amount-coins[i]>=0){
            int x = memoHelper(i,amount-coins[i],coins,dp);
            if(x==-1 && y==-1)return dp[i][amount] = -1;
            if(x==-1)return dp[i][amount] = y;
            if(y==-1)return dp[i][amount] = 1 + x;
            return dp[i][amount]= Math.min(1+x,y);
        }
        return dp[i][amount] = y;
    }
    // time and space complexity O(n*amount)
    public int bottomUp(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        //initialization
        // no matter that sum is , if we have no coins , ans is -1
        for(int sum = 0;sum<=amount;sum++)
            dp[0][sum] = -1;
        // no matter what # of coins is , if sum is 0 , ans is 0
        for(int n=1;n<=coins.length;n++)
            dp[n][0] = 0;
        for(int n=1;n<=coins.length;n++)
            for(int sum=1;sum<=amount;sum++){
                if(sum-coins[n-1]>=0){
                    int choice1 = dp[n][sum-coins[n-1]];
                    int choice2 = dp[n-1][sum];
                    if(choice1 ==-1 && choice2==-1)dp[n][sum]=-1;
                    else if(choice1==-1)dp[n][sum] = choice2;
                    else if(choice2==-1)dp[n][sum] = 1 + choice1;
                    else dp[n][sum] = Math.min(1+choice1,choice2);
                }
                else dp[n][sum] = dp[n-1][sum];
            }
        return dp[coins.length][amount];
    }
}
