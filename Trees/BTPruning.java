/* time O(N) , space O(height)
-> if we did not found current tree having 1 , we return null ,else we return current tree
-> So for every node , if we didn't found any leftsubtree and rightsubtree and node ==0 , we return null
-> else it means either we have left or right subtree having 1 in it ,or node ==1 we return current node.
*/
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root==null)return root;
        root.left= pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root.left==root.right && root.val==0 ? null : root;
    }
        
}
