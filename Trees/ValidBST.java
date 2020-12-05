//approach1 : time O(n) , space O(1)
//do inorder traversal. Instead of adding current visiting node to a list , compare it with previously visited node. Just like we do in list
class Solution {
    private TreeNode prev;
    public boolean isValidBST(TreeNode root) {
         prev = null;
         return  inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        while(root!=null){
            if(root.left==null){
                if(prev!=null && prev.val>=root.val)return false;
                prev = root;
                root=root.right;
            }
            else{
                TreeNode x= root.left;
                while(x.right!=null && x.right!=root)x=x.right;
                if(x.right==root){
                    x.right = null;
                    if(prev!=null && prev.val>=root.val)return false;
                    prev = root;
                    root=root.right;
                }
                else{
                    x.right = root;
                    root=root.left;
                }
            }
        }
        return true;
    }
}
// approach 2 : time O(n) , space O(Height)
//for every node , all values on left subtree should be < node and all values of right subtree  > node
// so this gives us a range of values where each node should lie. If the node lie outside this range , then it is not a BST
class Solution {
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean check(TreeNode root , long l, long r){
        if(root==null)return true;
        if(root.val<l || root.val>r)return false;
        return check(root.left,l,root.val-1L) && check(root.right,root.val+1L,r);
    }
}
