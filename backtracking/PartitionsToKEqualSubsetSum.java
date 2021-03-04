// time complexity : O(k*2^n), cuz for every subset, we traverse whole array and make 2 recursive calls atmost in each call.
/*
    approach : use backtacking
        --> consider we have sum of current subset as currSum and we are at index i and we want sum of each subset equal to reqSum = sum(nums[])/k,
        --> we will use a visited[] to keep hold of already used elements.
        --> if currSum + nums[i] > reqSum , we can only skip the ith element and goto next element
        --> if !visited[i] and currSum + nums[i] <= resSum , we have 2 choices , either to include it or not include it in current subset .
        --> if we include it , we will make visited[i] = true so that the current element can not be added to any other subset again
        --> if we found the taking this choice gives true , we will return true
        --> other wise , we will exclude nums[i] from currSum by making visited[i] = false and goto next element .
        --> if at any point if we found currSum == reqSum , it means we found a subset with required sum , so call backtrack for k-1 th subset from 0th index.
        --> if your k == 0, it means we found k subsets whose sum is reqSum.
*/
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int ele : nums)sum+=ele;
        if(sum%k!=0)return false;
        return backtrack(nums,0,sum/k,0,new boolean[nums.length],k);
    }
    private boolean backtrack(int[] nums,int i,int reqSum,int currSum,boolean[] isVisited,int k){
        if(k==0)return true;
        if(reqSum == currSum)
            return backtrack(nums,0,reqSum,0,isVisited,k-1);
        if(i==nums.length)return false;
        if(!isVisited[i] && nums[i]+currSum<=reqSum){
            isVisited[i] = true;
            if(backtrack(nums,i+1,reqSum,currSum+nums[i],isVisited,k))return true;
            isVisited[i] = false;
        }
        return backtrack(nums,i+1,reqSum,currSum,isVisited,k);
    }
}
