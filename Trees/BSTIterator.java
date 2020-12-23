//avg time O(1) for next() and hashNext(), space O(Height)
class BSTIterator {
    TreeNode root;
    Deque<TreeNode> st;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        st = new ArrayDeque<>();
    }
    
    public int next() {
            while(root!=null){
                st.push(root);
                root = root.left;
            }
        root = st.pop();
        int x = root.val;
        root=root.right;
        return x;
    }
    
    public boolean hasNext() {
        return root!=null || !st.isEmpty();
    }
}
