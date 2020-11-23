//recursive : O(n) time , O(height) space
class Solution {
    boolean ans;
    public boolean isBalanced(TreeNode root) {
        ans = true;
        height(root);
        return ans;
    }
    private int height(TreeNode root){
        if(root==null)return 0;
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r)>1)ans = false;
        return 1 + Math.max(l,r);
    }
}
