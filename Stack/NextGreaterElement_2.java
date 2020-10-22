//time O(n) , space o(n)
//approach : as the array is circular , we do not know for sure the last elemnent has no next greater element. So can not start from last.
// what we know for sure is that the maximum element in array has no next larger element. So starting from that position is great . 
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length==0)return new int[0];
        int zz = findMaxIndex(nums);
        int[] res = new int[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        int i = zz;
        while(true){
            while(!dq.isEmpty() && dq.peek()<=nums[i])dq.pop();
            res[i] = dq.isEmpty() ? -1 : dq.peek();
            dq.push(nums[i]);
            i--;
            if(i==-1)i=nums.length-1;    //as the array is circular , we need to go to right part after left part 
            if(i==zz)break;             // if we reach the element from where we started , then all element is processed.
        }
        return res;
    }
    private int findMaxIndex(int[] nums){
         int zz=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
                zz=i;
            }
        }
        return zz;
    }
}
