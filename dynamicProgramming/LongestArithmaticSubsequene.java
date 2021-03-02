// problem link : https://leetcode.com/problems/longest-arithmetic-subsequence/
// time and space complexity : O(1000*n)
/*
    approach : LIS variation
        --> let say we know the length of longest arithmetic subsequence with common difference d ending at index j , now for some i >j ,
        -->if we found the common difference btw arr[i] and arr[j] is also d(arr[i]-arr[j] = d) , then arr[i] will extend the arithmetic subsequence ending at j.
        --> The length of longest arithmetic ending at arr[i] with  common difference d = 1 + longest arithmetic ending at arr[j] with  common difference d
        --> so we created a 2d array arr, where arr[i][diff] tells longest arithmetic subsequence ending at index i with common difference diff
        -->for every j in 0 to i-1 , we find the length of longest arithmetic subsequence ending at i with difference arr[i]-arr[j]
        --> Since arr[i]-arr[j]  = [-500,500] , we added 500 to the diff just to remove -ve index error.
 */
public class LongestArithmaticSubsequence {
        public int longestArithSeqLength(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][1001];
            int max = 0;
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],1);
                for(int j=0;j<i;j++){
                    int diffIndex = 500+arr[i]-arr[j];
                    dp[i][diffIndex] = Math.max(dp[i][diffIndex],1 + dp[j][diffIndex]);
                    max = Math.max(max,dp[i][diffIndex]);
                }
            }
            return max;
        }
}
