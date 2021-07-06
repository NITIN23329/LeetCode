//problem link : https://leetcode.com/problems/sliding-window-maximum/
// time O(n)  , space O(k)
/*  approach : self explanitory
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && dq.peekLast()[0]<=nums[i])dq.removeLast();
            dq.addLast(new int[]{nums[i],i});
            if(dq.peekFirst()[1]==i-k)dq.removeFirst();
            if(i>=k-1)res[i-k+1] = dq.peekFirst()[0];
        }
        return res;
    }
}
