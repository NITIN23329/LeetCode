// time complexity : O(4 * n * max(n,m) * log(m)), space complexity : O(2 * n * max(n,m))
/*
  approach :
    --> left previous be the last element in our Increasing subsequence and we are at index i in arr1
    --> What choices do we have?
    --> if previous < arr1[i] the we can also add arr1[i] to our Increasing subsequence without any swapping.
    --> Another choice is we find the next greater element of previous in arr2 and assume it as our current element instead of arr1[i].
    --> if we can find such a element , we can add it to our Increasing subsequence swapping.
    --> To find next greater element in arr2, sort it and do a binary search.
*/
class Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
         Arrays.sort(arr2);
         int[][][] dp = new int[arr1.length][Math.max(arr1.length,arr2.length)][2];  
         for(int i=0;i<arr1.length;i++)
             for(int j=0;j<dp[0].length;j++)
                 dp[i][j] = new int[]{-2,-2};
         int c1 = helper(arr1,arr2,1,0,0,dp);
         int c2 = helper(arr1,arr2,1,0,1,dp);
         if(c1==-1 && c2==-1)return -1;
         if(c1==-1)return 1+c2;
         if(c2==-1)return c1;
         return Math.min(c1,1+c2);
    }                 
    private int helper(int[] arr1,int[] arr2,int i,int prev,int isSwapped,int[][][] dp){
         if(i==arr1.length)return 0;
         if(dp[i][prev][isSwapped]!=-2)return dp[i][prev][isSwapped];
         int previous;
         if(isSwapped==1)previous = arr2[prev];
         else previous = arr1[prev];
         int c1 = -1;
         int c2 = -1;
         if(arr1[i]>previous)
             c1 = helper(arr1,arr2,i+1,i,0,dp);
         int nextIndex = bs(arr2,previous,0,arr2.length-1);
         if(nextIndex!=-1)
             c2 = helper(arr1,arr2,i+1,nextIndex,1,dp);
         if(c1==-1 && c2==-1)return dp[i][prev][isSwapped] = -1;
         if(c1==-1)return dp[i][prev][isSwapped] = 1+c2;
         if(c2==-1)return dp[i][prev][isSwapped] = c1;
         return dp[i][prev][isSwapped] = Math.min(c1,1+c2);
    }
    private int bs(int[] arr,int ele,int l,int r){
        if(l>r)return -1;
        int mid = (r-l)/2 + l;
        if(mid+1<arr.length && arr[mid]<=ele && arr[mid+1]>ele)
            return mid+1;
        if(arr[mid]<=ele)
            return bs(arr,ele,mid+1,r);
        return bs(arr,ele,l,mid-1);
    }
}
