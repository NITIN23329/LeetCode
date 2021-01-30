import java.util.Arrays;
//problem link : https://leetcode.com/problems/coin-change-2/
public class CoinChange2 {
    /*
        approach : this problem is similar to count subsets with given sum, where sum =amount
            --> a minor difference is we can use a particular value any # of times like unbounded knapsack
            --> so for a particular coin we can
                    --> either reduce amount by current coin value and recursively call for this coin again
                    --> we ignore this coin and goto next coin
            --> remember we can pick a coin as long as sum of all coins <= amount required
     */
    public int recursive(int amount, int[] coins) {
        return recursiveHelpr(0, amount, coins);
    }
    private int recursiveHelpr(int i, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (amount - coins[i] >= 0)
            return recursiveHelpr(i, amount - coins[i], coins) + recursiveHelpr(i + 1, amount, coins);
        return recursiveHelpr(i + 1, amount, coins);
    }
    // time and space complexity O(n*amount)
    // memoization of above recursive code
    public int memoization(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) Arrays.fill(dp[i], -1);
        return memoHelper(0, amount, coins, dp);
    }

    private int memoHelper(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];
        if (amount - coins[i] >= 0)
            return dp[i][amount] = memoHelper(i, amount - coins[i], coins, dp) + memoHelper(i + 1, amount, coins, dp);
        return dp[i][amount] = memoHelper(i + 1, amount, coins, dp);
    }
    // iterative bottom up dp approach with time and space complexity O(n*amount)
    /*
       dp[i][sum] : the number of combinations to make up amount=sum by using the first i types of coins
        State transition:
            not using the ith coin, only using the first i-1 coins to make up amount sum, then we have dp[i-1][j] ways.
            using the ith coin, since we can use unlimited same coin, we need to know how many ways to make up amount sum - coins[i-1] by using first i coins(including ith), which is dp[i][sum-coins[i-1]]
     */
    public int bottomUp(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        // initialization
        // no matter how many coins we have , we can make 0 amount in exactly 1 way
        for(int i=0;i<=coins.length;i++)
            dp[i][0] = 1;
        for(int i=1;i<=coins.length;i++)
            for(int sum = 1;sum<=amount;sum++)
                if(sum - coins[i-1]>=0)
                    dp[i][sum] = dp[i][sum-coins[i-1]]+dp[i-1][sum];
                else dp[i][sum] = dp[i-1][sum];
        return dp[coins.length][amount];
    }
}
