class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> st = new Stack<>();
        for(int i=T.length-1;i>=0;i--){
            while(!st.isEmpty() && T[st.peek()]<=T[i])st.pop();
            res[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return res;
    }
}
