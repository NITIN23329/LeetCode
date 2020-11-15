class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)return true;
        boolean ans = true;
        if(root.left!=null)
            ans = ans && root.val==root.left.val && isUnivalTree(root.left);
        if(root.right!=null && ans)
            ans = ans && root.val==root.right.val && isUnivalTree(root.right);
        return ans;
    }
}
