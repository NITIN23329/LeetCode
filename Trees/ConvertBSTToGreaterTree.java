//time O(N) reverse inorder traversal
class Solution {
    private int sum;
    public TreeNode convertBST(TreeNode root) {
        sum=0;
       convert(root);
        return root;
    }
    private void convert(TreeNode root){
        if(root==null)return;
        convert(root.right);
        root.val+=sum;
        sum=root.val;
        convert(root.left);
    }
}
