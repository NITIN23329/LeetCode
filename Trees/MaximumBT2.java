//time O(N) , space O(height)
class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null)
            root = new TreeNode(val);
        else if(root.val>val)
            root.right = insertIntoMaxTree(root.right,val);
        else {
            TreeNode x = new TreeNode(val);
            x.left = root;
            root = x;
        }
        return root;
        
    }
}
