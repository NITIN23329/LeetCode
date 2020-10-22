// on an average next() and hasNext() take O(1) time and O(1) space ... but preprocessing takes O(N) time and space both.
// approach : using the inorder traversal of BST (gives sorted value)
class BSTIterator {
    ArrayList<Integer> list;
    int i;
    public BSTIterator(TreeNode root) {
        list=  new ArrayList<>();
        inOrder(root);
        i=0;
    }
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return list.get(i++);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return i<list.size() ? true : false;
    }
}
// using Stack approach( Deque is preffered compared to stack)
//detailed solution https://leetcode.com/problems/binary-search-tree-iterator/solution/
//space of next() is O(h) cuz maximum possible size of dq  = height of BST (h). space of hasNext is O(1) on average
// time complexity of hasNext() is O(1)
/*time complexity of next() :"Each node gets pushed and popped exactly once in next() when iterating over all N nodes. 
 *Actually, it's less than that because we run find_smallest(root) during the BSTIterator initialization which takes O(H). 
 *So, N calls to next() take in total O(2N-H) = O(2N), which makes the amortized cost of each next() call O(1)."*/
class BSTIterator {
    TreeNode root;
    Deque<TreeNode> dq;
    public BSTIterator(TreeNode root) {
        this.root = root;
        dq = new ArrayDeque<>();
        process(root);
    }
    
    private void process(TreeNode root){
         while(root!=null){
            dq.push(root);
            root= root.left;
        }
    }
    public int next() {
        TreeNode iter = dq.pop();
        int val = iter.val;
        if(iter.right!=null)
            process(iter.right);
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !dq.isEmpty();
    }
}
