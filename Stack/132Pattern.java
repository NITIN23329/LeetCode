class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            left[i] = min;
            min = Math.min(min,nums[i]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] right = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && left[i]>=dq.peek())
                dq.pop();
            right[i] = dq.isEmpty()? Integer.MAX_VALUE :dq.peek();
            dq.push(nums[i]);
        }
        for(int i=0;i<n;i++){
            if(left[i]<right[i] && right[i]<nums[i])
                return true;
        }
        return false;
    }
}
