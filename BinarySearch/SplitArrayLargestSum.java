// time complexity : O(n*log(sum(nums))
/*
  approach : As we need to find mimimum value of greatest subarray sum.
  --> let say a mid sum is in range 0 to sum(nums)
  --> Then we check if we are able to divide the nums array to atmost m subarrays such that the largest subarray sum <= mid sum. 
  --> And if are not able to do so for sum value = mid+1 the we return mid as min is the smallest possible largest subarray sum
  --> If both are possible then left half else goto right half.
*/
class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        for(int ele : nums)sum+=ele;
        return bs(nums,0,sum,m);
    }
    private int bs(int[] nums,int l,int r,int m){
        if(r<l)return -1;
        int mid = (r-l)/2 + l;
        boolean now = isPossible(nums,mid,m);
        boolean before = isPossible(nums,mid-1,m);
        if(now && !before)
            return mid;
        if(now)
            return bs(nums,l,mid-1,m);
        return bs(nums,mid+1,r,m);
    }
    private boolean isPossible(int[] nums,int sum,int m){
        int curr = 0;
        for(int ele : nums){
            if(ele>sum)return false;
            if(curr+ele>sum){
                curr = ele;
                m--;
                if(m==0)return false;
            }else curr+=ele;
        }
        return true;
    }
}
