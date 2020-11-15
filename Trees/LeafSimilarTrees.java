//approach 1 : iterative using stack
//time O(n) , space O(2^height)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        traverse(root1,l1);
        traverse(root2,l2);
        return l1.equals(l2);
    }
    private void traverse(TreeNode root , ArrayList<Integer> l){
        if(root==null)return;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        while(!dq.isEmpty()){
            TreeNode x = dq.pop();
            if(x.left==null && x.right==null)l.add(x.val);
            if(x.right!=null)dq.push(x.right);
            if(x.left!=null)dq.push(x.left);
        }
    }
}

// approach 2 : using morris inorder traversal
//time O(n) ,  space O(2^height)
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        traverse(root1,l1);
        traverse(root2,l2);
        //System.out.println(l1+" "+l2);
        return l1.equals(l2);
    }
    private void traverse(TreeNode root , ArrayList<Integer> l){
        while(root!=null){
            if(root.left==null){
                if(root.right==null)l.add(root.val);
                root = root.right;
            }
            else{
                TreeNode x = root.left;
                while(x.right!=null && x.right!=root)x=x.right;
                if(x.right==root){
                    x.right=null;
                    if(x.left==null)l.add(x.val);
                    root = root.right;
                }
                else{
                    x.right = root;
                    root=root.left;
                }
            }
        }
    }
}
