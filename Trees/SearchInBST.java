//recursive
// time O(height) : space O(height)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        if(root.val==val)return root;
        if(root.val<val)return searchBST(root.right,val);
        return searchBST(root.left,val);
    }
}
//iterative
//time O(height) : space o(1)
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(root.val == val)break;
            if(root.val<val)root = root.right;
            else root = root.left;
        }
        return root;
    }
}
