// time and space complexity : O(n)
// find and store with indeces can be visited starting from 0.
// start from index 0 so mark it visited.
// for every index,start from index + nums[index] and travel back upto index and mark all of them, visited.
// if any index in btw found visited, then all left indeces are also visited so stop and move to next index. 
// if any index from which we are starting found unvisited, return false.
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canVisit = new boolean[n];
        canVisit[0] = true;
        for(int start=0;start<n-1;start++){
            if(!canVisit[start])return false;
            int end = Math.min(n-1,start + nums[start]);
            while(end>=start && !canVisit[end])
                canVisit[end--] = true;
        }
        return canVisit[n-1];
    }
}
