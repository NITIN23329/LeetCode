class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> st = new ArrayDeque<>();
        while(head!=null){
            list.add(head.val);
            head=  head.next;
        }
        int[] res = new int[list.size()];
        int n = res.length;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && list.get(i)>=st.peek())st.pop();
            res[i] = st.isEmpty()? 0 : st.peek();
            st.push(list.get(i));
        }
        return res;
    }
}
