class MinStack {
    LinkedList<Integer> st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new LinkedList<>();
    }
    
    public void push(int x) {
        int min = st.isEmpty() ? x : Math.min(x,st.peekLast());
        st.add(x);
        st.add(min);
    }
    
    public void pop() {
        st.removeLast();
        st.removeLast();
    }
    
    public int top() {
        int y =  st.removeLast();
        int x = st.peekLast();
        st.add(y);
        return x;
    }
    
    public int getMin() {
        return st.peekLast();
    }
}
