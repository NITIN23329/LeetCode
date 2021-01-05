//problem link : https://leetcode.com/problems/sliding-window-maximum/
// time O(n)  , space O(k)
/*  approach : self explanitory
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        int n = nums.length;
        int[] arr = new int[n-k+1];
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && dq.peekLast()[0]<nums[i])dq.pollLast();
            dq.addLast(new int[]{nums[i],i});
        }
        arr[0]  = dq.peekFirst()[0];
        for(int i=k;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()[1]<=i-k)dq.pollFirst();
            while(!dq.isEmpty() && dq.peekLast()[0]<nums[i])dq.pollLast();
            dq.addLast(new int[]{nums[i],i});
            arr[i-k+1] = dq.peekFirst()[0];
        } 
        return arr;
    }
}
