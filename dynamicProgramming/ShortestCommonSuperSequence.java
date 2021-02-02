class Solution {
    // time complexity and space complexity O(nm)
    public String shortestCommonSupersequence(String str1, String str2) {
        // finding length of longest common subsequence
        int n = str1.length();int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
        // finding shortest common supersuquence string.
        // starting from i=n,j=m
        // if str1[i-1] == str2[j-1], it is a lcs character add str1[i-1] once and goto i-1,j-1
        // else if dp[i-1][j]>dp[i][j-1]  , add str1[i-1] and goto i-1
        // else add str2[j-1] and goto j-1; 
        // at last either str1 or str2 will be incompletely traversed , add all of it
         StringBuilder scs = new StringBuilder();
        int i=n;int j=m;
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                scs.append(str1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                scs.append(str1.charAt(--i));
            }
            else {
                 scs.append(str2.charAt(--j));
            }
        }
        while(i>0)scs.append(str1.charAt(--i));
        while(j>0)scs.append(str2.charAt(--j));
        scs.reverse();
        return scs.toString();
    }
}
