/* time O(n) , space O(n)
*first find the smallest value on left for each element . Store it in left array.
*using stack, for each i,
find the smallest element for each i on right side.,which is greater than left[i] .
*correctness of this approaach:
* left[] array is a increasing array left[i]<=left[j] , i<j.
* Suppose we are at index i and we found a element x>left[i] to right of i. Then 2 cases are possible,
    if x<nums[i] then we found a valid combination,
    if x > nums[i] and if there is another element on the right of x which < nums[i](which we can not see at index i) then left[i],
        that element and x will be a valid combination when we are processing index of x.
*/

// 2 pass stack solution
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
