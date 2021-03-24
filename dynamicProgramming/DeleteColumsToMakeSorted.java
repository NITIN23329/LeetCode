// time complexity : O( n * len(strs[0])^2) , space complexity : O(len(strs[0])
/*
  approach : variation of LIS
  --> let dp[i] represents the LIS ending at character i for all string in strs. where 0<=i<=len(strs[0])
  --> consider we are at index i in any string of strs.
  --> for all j = 0 to i-1, and for all string in strs(0<=k<=n-1), if strs[k][j] <= strs[k][i], we can append character at index i to LIS ending with character at index j for all strings.
  --> find the maximum length we can get considering all strings. Now we need to remove all other characters for all strings .
*/
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int size = strs[0].length();
        int max = 0;
        int[] dp = new int[size];
        for(int i=0;i<size;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                boolean isInc = true;
                for(int k=0;k<n;k++)
                    if(strs[k].charAt(j)>strs[k].charAt(i)){
                        isInc = false;
                        break;
                    }
                if(isInc)dp[i] = Math.max(dp[i],1 + dp[j]);
            }
            max = Math.max(max,dp[i]);
        }
        return size - max;
            
    }
}
