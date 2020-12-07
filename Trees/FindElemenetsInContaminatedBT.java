//approach 1 : time O(n) for find() , space O(height) for find()
class FindElements {
    private TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
    }
    public boolean find(int target) {
        if(root==null)
            return false;
        TreeNode t = root;
        return lookUp(t,target,0);
    }
    private boolean lookUp(TreeNode tree,int x,int curr){
        if(tree==null)return false;
        if(curr>x)return false;
        return curr==x || 
            lookUp(tree.left,x,2*curr+1) || lookUp(tree.right,x,2*curr+2);
    }
}

//approach 2 : using set preprocess the tree, time O(1) for find() , space O(n) for find()
class FindElements {
    private TreeNode root;
    private Set<Integer> set;
    public FindElements(TreeNode root) {
        this.root = root;
        set = new HashSet<>();
        process(this.root,0);
    }
    private void process(TreeNode tree , int x){
        if(tree==null)return;
        set.add(x);
        process(tree.left,2*x+1);
        process(tree.right,2*x+2);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
