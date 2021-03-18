/*
  approach 1 : 
    --> we have 2 divide array into different subarrays.
    --> we will use 2 pointer techinque : l,r. l represents index of starting element and r represents ending index for a particular subarray
    --> we can make subarrays haveing elements upto k
    --> so if we have less than k elements, we have 2 choices:
        --> either to close current subarray or to continue adding elements to it
        --> if we  choose to close, we will find sum for current subarry( # of elements * max value) and start a new subarray : f(r+1,r+1)
        --> if we want to continue adding elements we goto : f(l,r+1).
   --> if we have exactly k elements, we need to create a new subarray : l=r+1,r=r+1.
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return helper(arr,0,0,k);
    }
    private int helper(int [] arr,int l,int r,int k){
        if(r==arr.length)return 0;
        if(r-l+1<=k){
            int max = 0;
            for(int i=l;i<=r;i++)max = Math.max(max,arr[i]);
            return Math.max((r-l+1)*max + helper(arr,r+1,r+1,k),helper(arr,l,r+1,k));
        }
        return helper(arr,r+1,r+1,k);
    }
}
// memoization with time and space complexity : O(n^2)
// instead of calculating max in btw l to r, we will pre calculate it and store it in max[].
// So finding max Value in range l to r takes O(1) time.
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] max = new int[n][n];
        for(int l=0;l<n;l++){
            max[l][l] = arr[l];
            for(int r=l+1;r<n;r++)
                max[l][r] = Math.max(max[l][r-1],arr[r]);
        }
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return helper(arr,0,0,k,dp,max);
    }
    private int helper(int [] arr,int l,int r,int k,int[][] dp,int[][] max){
        if(r==arr.length)return 0;
        if(dp[l][r]!=-1)return dp[l][r];
        if(r-l+1<=k){
            int maxVal = max[l][r];
            return dp[l][r] = Math.max((r-l+1)*maxVal + helper(arr,r+1,r+1,k,dp,max),helper(arr,l,r+1,k,dp,max));
        }
        return  dp[l][r] = helper(arr,r+1,r+1,k,dp,max);
    }
}
// another faster approach with time complexity O(nk) and space complexity : O(n)
/*
  approach :
      --> let say our current subarray ends at index i. How many subarrays can be created such that it will end at index i?
      --> exactly k subarray are there.
      --> so for every i in range o to n-1, we will assume that our current subarray ends at index i.
      --> we will find all such possible subarray j = [i-k+1,i], where j is starting of subarray and i in ending of subarray.
      --> let say dp[i] stores maximum sum possible ending at arr[i].
      --> so we will find all possible answers for a subarray ending at i. and we take max of all to find maxinum sum ending at i.
      --> for a particular subarray starting at j and ending at i, we find max sum ending at (j-1) + # of elements in [j,i]* max element in (j,i).
      --> for a particular [j,i]. dp[i] = dp[j-1] + (i-j+1) * max in range(j,i).
      
*/
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=i;j>=i-k+1 && j>=0;j--){
                max = Math.max(max,arr[j]);
                dp[i] = Math.max(dp[i],(i-j+1)*max + (j==0? 0 : dp[j-1]));
            }   
        }
        return dp[n-1];
    }
    
}
