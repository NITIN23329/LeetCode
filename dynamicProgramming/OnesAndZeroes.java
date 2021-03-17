// memoization code with time and space complexity : O(n*m*len(strs))
/*
  approach : for every string we have 2 choices, either to add it or to not add it
  --> if we add it , our remaining # of 1s reduces by the # of 1s in the string and remaining # of 0s reduced by # of 0s in string
  --> if we dont add it ,we goto next string.
*/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int size = strs.length;
        int[] ones = new int[size];
        int[] zeroes = new int[size];
        findCount(strs,ones,zeroes);
        int[][][] dp = new int[size][m+1][n+1];
        for(int i=0;i<size;i++)
            for(int j=0;j<=m;j++)
                Arrays.fill(dp[i][j],-1);
        return helper(ones,zeroes,0,m,n,dp);
        
    }
    private int helper(int[] ones,int[] zeroes,int i,int m,int n,int[][][] dp){
        if(i == ones.length)return 0;
        if(dp[i][m][n]!=-1)return dp[i][m][n];
        if(ones[i]<=n && zeroes[i]<=m)
            return dp[i][m][n] = Math.max(1+helper(ones,zeroes,i+1,m-zeroes[i],n-ones[i],dp),
                            helper(ones,zeroes,i+1,m,n,dp));
        return dp[i][m][n] = helper(ones,zeroes,i+1,m,n,dp);
    }
    private void findCount(String[] strs,int[] ones,int[] zeroes){
        for(int i=0;i<strs.length;i++){
            int oneCount = 0;
            for(int j=0;j<strs[i].length();j++)
                if(strs[i].charAt(j)=='1')oneCount++;
            ones[i] = oneCount;
            zeroes[i] = strs[i].length()-oneCount;
        }
    }
}
