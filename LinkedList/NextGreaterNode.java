class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int n = list.size();
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int x = list.get(i);
            while(!st.isEmpty() && x>=st.peek()){
                st.pop();
            }
            if(st.isEmpty())arr[i]=0;
            else arr[i]=st.peek();
            st.push(x);
        }
        return arr;
    }
}
