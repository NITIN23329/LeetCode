//time O(n) , space O(height)
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)return root;
        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);
        return root.left==root.right && target==root.val? null : root;
    }
}
