/* time O(n) , space O(n)
*first find the smallest value on left for each element . Store it in left array.
*using stack, for each i,
find the smallest element for each i on right side.,which is greater than left[i] .
*correctness of this approaach:
1)left[] array is a decreasing array left[i]>=left[j] , i<j.
2)  for finding smaller on right we are traversing from right to left, 
so , for each j , if there is a value on right which is smaller than left[j] ,we will pop it.(as it is automatically smaller than left[i].
*/
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
// optimization of above problem : 2 pass solution
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
        for(int i=n-1;i>=0;i--){
            while(!dq.isEmpty() && left[i]>=dq.peek())
                dq.pop();
            if(!dq.isEmpty()){
                if(nums[i]>dq.peek())return true;
            }
            dq.push(nums[i]);
        }
        return false;
    }
}
