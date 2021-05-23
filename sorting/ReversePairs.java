// time complexity : O(nlogn), space complexity : O(n) same as of merge sort
/*
  Approach : use the merge function of mergeSort() to count reverse pairs.
      --> The task is that we are given 2 sorted array find # of pairs (i,j) where i belongs to left array and j belongs to right array and left[i] > 2 * right[j].
      --> We must do this in O(n) time.
      --> The idea is that if we are at index i in left array and j in right array such that all pairs (i,jj<=j) are reverse ,
          --> All reverse pairs with index i must me reverse pairs for index i+1 as arr[i+1]> arr[i].
          --> and plus we can new even consider some index jj>j now such that arr[i+1] > 2 * arr[jj].
      
*/
class Solution {
    public int reversePairs(int[] arr) {
        return mergeSort(arr,0,arr.length-1);
    }
    private  int mergeSort(int[] arr,int l,int r){
        if(l>=r)return 0;
        int mid = ((r-l)>>1)+l;
        return mergeSort(arr,l,mid) +  mergeSort(arr,mid+1,r) 
            + merge(arr,l,mid,r);
    }
    private int merge(int[] arr,int l,int mid,int r){
        int[] temp = new int[r-l+1];
        // count reverse pairs
        int j = mid;
        int count = 0;
        for(int ii=l;ii<=mid;ii++){
            while(j<r && isReverse(arr[ii],arr[j+1]))j++;
            count += (j-mid);
        }
        // normal merge sort code 
        j=mid+1;
        int i = l,k = 0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j])temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while(i<=mid)temp[k++] = arr[i++];
        while(j<=r)temp[k++] = arr[j++];
        for(int m=0;m<temp.length;m++)
            arr[l+m] = temp[m];
        return count;
    }
    // this is used only as 2 * arr[i] leads of integer overflow.
    private boolean isReverse(long a, long b){
        return a > 2 * b;
    }
}
