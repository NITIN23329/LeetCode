// recursive code 
/*
    approach : variation of partition of array
      --> after every element, we have 2 choices: either to end out current subarray or to continue
      --> for every subarray we will keep hold of its start(l) and end(r) index.
      --> if we wish to end the subarray, we will calculate the avg of current subarray and start a new subarray from r+1.
      --> if we dont wish to end the current subarray, we will goto next element r+1.
      --> if we have k==1, we will take up all elements from l to last of array and find its avg cuz every element must belong to a particular subarray.
*/
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] sum = new int[n+1];
        for(int i=0;i<n;i++)
            sum[i+1] = sum[i] + A[i];
        return helper(A,K,0,0,sum);
    }
    private double helper(int[] arr,int k,int l,int r,int[] sum){
        if(r==arr.length)return 0;
        if(k==1)return (sum[arr.length]-sum[l])/(arr.length-l+0d);
        double c1 = (sum[r+1]-sum[l])/(r-l+1d) + helper(arr,k-1,r+1,r+1,sum);
        double c2 = helper(arr,k,l,r+1,sum);
        return Math.max(c1,c2);
    }
}
// memoization of above recursive code with time and space complexity : O(n*n*k)
// note that the average can not be 0 ,so we do not need any initialization by -1.
class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] sum = new int[n+1];
        for(int i=0;i<n;i++)
            sum[i+1] = sum[i] + A[i];
        double[][][] dp = new double[n][n][K+1];
        return helper(A,K,0,0,sum,dp);
    }
    private double helper(int[] arr,int k,int l,int r,int[] sum,double[][][] dp){
        if(r==arr.length)return 0;
        if(k==1)return (sum[arr.length]-sum[l])/(arr.length-l+0d);
        if(dp[l][r][k]!=0)return dp[l][r][k];
        double c1 = (sum[r+1]-sum[l])/(r-l+1d) + helper(arr,k-1,r+1,r+1,sum,dp);
        double c2 = helper(arr,k,l,r+1,sum,dp);
        return dp[l][r][k] = Math.max(c1,c2);
    }
}
