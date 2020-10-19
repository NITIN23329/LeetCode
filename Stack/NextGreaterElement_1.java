class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] greater = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            int x = nums2[i];
            while(!st.isEmpty() && st.peek()<x)st.pop();
            if(st.isEmpty())greater[i]=-1;
            else greater[i]=st.peek();
            st.push(x);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
            map.put(nums2[i],greater[i]);
        int[] res = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
            res[i] = map.get(nums1[i]);
        return res;
        
    }
}
