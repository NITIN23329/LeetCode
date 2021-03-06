// time complexity O(n^2), and space complexity O(n)
/*
  approach : using LCS
    --> for i in range 0 to n-2 , let say our wiggle sequence ending at number at index i
    --> for every j in 0 to i-1 , if nums[j]>nums[i] , then {nums[j],nums[i]} has a -ve differnce , so len of wiggle ending with i with -ve diff = 1 + wiggle ending at nums[j] with +ve diff
    --> if nums[j]<nums[i], then {nums[j],nums[i]} has a +ve difference, so len of wiggle ending with i with +ve diff = 1 + wiggle length ending at nums[j] with -ve diff
    --> return max of both cases.
*/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        int max = 0;
        for(int i=0;i<n;i++){
            inc[i] = 1;
            dec[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    inc[i] = Math.max(inc[i],1 + dec[j]);
                else if(nums[i]<nums[j])
                    dec[i] = Math.max(dec[i],1 + inc[j]);
            }
            max = Math.max(max,Math.max(inc[i],dec[i]));
        }
        return max;
    }
}
// time and space complexity O(n), however space complexity can be reduced to O(1)
/*
  --> let say we are at i where i is in range to 1 ....n-1
      --> if nums[i] > nums[i-1] ,then we have 2 choices.
          --> if we want to incluce nums[i] , wiggle length ending at i with +ve diff = 1 + wiggle length ending at i-1 with -ve diff
          --> or we don't include nums[i] , then wiggle length ending at i with +ve diff =  wiggle length ending at i-1 with +ve diff
          --> we take max of both case to get wiggle length ending at i with +ve diff.
          --> and wiggle length ending at i with -ve diff =  wiggle length ending at i-1 with -ve diff , we can not get -ve diff for nums[i] from nums[i-1] as nums[i]>nums[i-1].
      --> if nums[i] < nums[i-1] ,then we have 2 choices.
          --> if we want to incluce nums[i] , wiggle length ending at i with -ve diff = 1 + wiggle length ending at i-1 with +ve diff
          --> or we don't include nums[i] , then wiggle length ending at i with -ve diff =  wiggle length ending at i-1 with -ve diff
          --> we take max of both case to get wiggle length ending at i with -ve diff.
          --> and wiggle length ending at i with +ve diff =  wiggle length ending at i-1 with +ve diff , we can not get +ve diff for nums[i] from nums[i-1] as nums[i]<nums[i-1].
     --> if nums[i-1] == nums[i]
            --> we don't include nums[i] , then wiggle length ending at i with +ve diff =  waggle length ending at i-1 with +ve diff
            --> we don't include nums[i] , then wiggle length ending at i with -ve diff =  waggle length ending at i-1 with -ve diff
     
*/
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n==0)return 0;
        int[] inc = new int[n];
        int[] dec = new int[n];
        inc[0] = dec[0] = 1;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                inc[i] = Math.max(inc[i-1],1 + dec[i-1]);
                dec[i] = dec[i-1];
            }
            else if(nums[i]<nums[i-1]){
                dec[i] = Math.max(dec[i-1],1 + inc[i-1]);
                inc[i] = inc[i-1];
            }
            else{
                dec[i] = dec[i-1];
                inc[i] = inc[i-1];
            }
        }
        return Math.max(inc[n-1],dec[n-1]);
    }
}
