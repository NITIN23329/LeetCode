// memoization  time and space complexity O(N)
/*
    approach :
       --> for every i in 0 to n-1, we have 2 choices, either to swap i or not.
       --> so we will have a variable prevSwapped, which is 1 when i-1th index is swapped else 0 cuz comparision for ith index depends whether i-1 th element is swapped or not.
       --> if prev index element is swappeed 
          --> if A[i] > B[i-1] && B[i] > A[i-1] we dont need to swap ith index
          --> if A[i] > A[i-1] && B[i] > B[i-1] we can also swap ith index.
      --> if prev index is not swapped
        --> if A[i] > A[i-1] && B[i] > B[i-1] we dont need to swap ith index
        --> if  A[i] > B[i-1] && B[i] > A[i-1] we can swap ith index.
      --> we will return min of all choices.
*/


class Solution {
    public int minSwap(int[] A, int[] B) {
        int[][] dp = new int [A.length][2];
        for(int i=0;i<dp.length;i++)dp[i] = new int[]{-1,-1};
        return Math.min(1+helper(A,B,1,1,dp),helper(A,B,1,0,dp));
    }
    private int helper(int[] A,int[] B,int i,int prevSwapped,int[][] dp){
       if(i==A.length)return 0;
       int c1 = 10000,c2 = 10000;
        if(dp[i][prevSwapped]!=-1)return dp[i][prevSwapped];
        if(prevSwapped==1){
            if(A[i]>B[i-1] && B[i]>A[i-1])c1 = helper(A,B,i+1,0,dp);
            if(A[i]>A[i-1] && B[i]>B[i-1]) c1 = Math.min(c1,1 + helper(A,B,i+1,1,dp));
        }
        else {
            if(A[i]>A[i-1] && B[i]>B[i-1])c2 = helper(A,B,i+1,0,dp);
            if(A[i]>B[i-1] && B[i]> A[i-1])c2 = Math.min(c2,1 + helper(A,B,i+1,1,dp));
        }
        return dp[i][prevSwapped] = Math.min(c1,c2);
    }
}
// bottom up dp with time ans space complexity : O(n)
class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[] swap = new int[n];
        int[] no_swap = new int[n];
        swap[0] = 1;
        for(int i=1;i<n;i++){
            swap[i] = no_swap[i] = 10000;
            if(A[i]>A[i-1] && B[i]>B[i-1]){
                no_swap[i]  = Math.min(no_swap[i],no_swap[i-1]);
                swap[i] = Math.min(swap[i], 1 + swap[i-1]);
            }
            if(A[i]>B[i-1] && B[i]>A[i-1]){
                swap[i] = Math.min(swap[i],1 + no_swap[i-1]);
                no_swap[i] = Math.min(no_swap[i],swap[i-1]);
            }
        }
        return Math.min(swap[n-1],no_swap[n-1]);
    }
}
