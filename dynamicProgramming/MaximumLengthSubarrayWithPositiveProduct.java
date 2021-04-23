// time complexity : O(N), space complexity : O(N), it can be reduced if we store previous index answer in varibles.
/*
    approach : use dp. Try out different examples and see how to derive answer for index i using answer of index i-1.
    --> Let say posLen[i] represents max len of subarrays whose product is +ve and ending at index i.
    --> Let say negLen[i] represents max len of subarray whose product is -ve and ending at index i.
    --> if nums[i] == 0, this is a trivial case, so posLen[i] = negLen[i] = 0.
    --> if nums[i] > 0 , 
            --> subarray whose product is +ve and ending at index i = 1 +  subarray whose product is +ve and ending at index i - 1.
            --> subarray whose product is -ve and ending at index i = 1 +  subarray whose product is -ve and ending at index i - 1.
            --> If subarray whose product is -ve and ending at index i - 1 is not found, then subarray whose product is -ve and ending at index i = 0.
    --> if nums[i] < 0,
          --> subarray whose product is +ve and ending at index i = 1 +  subarray whose product is -ve and ending at index i - 1.
          --> If subarray whose product is -ve and ending at index i - 1 is not found, then subarray whose product is +ve and ending at index i = 0.
          -->  subarray whose product is -ve and ending at index i = 1 +  subarray whose product is +ve and ending at index i - 1.
   --> Find maxof posLen[], this is our answer.
*/
class Solution {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int[] posLen = new int[n];
        int[] negLen = new int[n];
        
        if(nums[0]>0)posLen[0]=1;
        else if(nums[0]<0)negLen[0] = 1;
        
        int maxLen = posLen[0];
        
        for(var i=1;i<n;i++){
            if(nums[i]>0){
                posLen[i] = posLen[i-1] +1;
                if(negLen[i-1]>0)negLen[i] = negLen[i-1] + 1;
            }
            else if(nums[i]<0){
                if(negLen[i-1]>0)posLen[i] =negLen[i-1] + 1;
                negLen[i] = posLen[i-1] + 1;
            }
            else {
                negLen[i] = 0;
                posLen[i] = 0;
            }
            maxLen = Math.max(maxLen,posLen[i]);
        }
        return maxLen;
    }
}
/*
Test Cases : 
[1,-2,-3,4]
[0,1,-2,-3,-4]
[-1,-2,-3,0,1]
[-1,2]
[1,2,3,5,-6,4,0,10]
[-1,1,2,3]
[-1,-2,-3,4,5]
[0,1,-2,-3,-4]
[-1,-2,-3,-4,-5,6]
[-2,-6,4,-2,-3,-6]
[5,4,-3,-2,-1,6]
[1,2,3,4,-6,-7,-8,-9]
[5,-4,3,-5,2,-4]
[-1,-2,-4,-5]
[-1,-2,-3]
[1,2,3,4,5,6]
[1,-5,4,-2,3,-6,1]
[-1,-2,-3,-4,-5,6,0]
[1,0,2,3,5,0,-6,-4,-10,-10]
[1,0,2,3,5,0,-6,-4,-10]
[0,0,0,-1,0,0,-9]
[0,0,0,-1,-2,0,5]
*/
