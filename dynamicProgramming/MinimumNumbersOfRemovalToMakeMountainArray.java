// time complexity : O(n^2), space complexity : o(n)
/*
  approach : variation of LIS.
  --> for every index i, x = find length of LIS ending at i, y = find length of LDS starting at i. 
  --> So max length of Mountain array including index ith element = x + y - 1 (index i element is considered twice).
  --> Find maximum for all i's and return n  -  max length of Mountain array . This is min # of removals to make .
  --> One thing to keep in mind is that our mountains array should be of form {smaller,larger,smaller} . Cases like {smaller,larger} or {larger,smaller} are invalid.
  --> So if we consider ith index element, the Mountain array must constains element < nums[i] and element > nums[j].
  --> In other words inc[i]>1 and dec[i]>1.
  --> A corner case : [10,5,4,3,20,2]
*/
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        for(int i=0;i<n;i++){
            inc[i] = 1;
            for(int j=0;j<i;j++)
                if(nums[j]<nums[i])
                    inc[i] = Math.max(inc[i], 1 + inc[j]);
        }
        for(int i=n-1;i>=0;i--){
            dec[i] = 1;
            for(int j=n-1;j>i;j--)
                if(nums[i]>nums[j])
                    dec[i] = Math.max(dec[i],1 + dec[j]);
        }
        int maxLen = 1;
        for(int i=0;i<n;i++)
            if(inc[i]>1 && dec[i]>1)
                maxLen = Math.max(maxLen, inc[i] + dec[i] -1);
        return n - maxLen;
    }
}
