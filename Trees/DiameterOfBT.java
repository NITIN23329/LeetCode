/*approach  ,  do post order traversal
*find height of left and right subtree , 
*and 1 to it(for current node) to get maximum no of nodes in the path from left subtree to right sub tree.
*/
//time O(n)  , space O(height)
class Solution {
    private int ans; 
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        if(root==null)return 0;
        helpr(root);
        return ans-1;
    }
    private int helpr(TreeNode root){
        if(root==null)
            return 0;
        int l = helpr(root.left);
        int r  = helpr(root.right);
        ans =Math.max(ans , l+r+1);
        return 1  + Math.max(l,r);
    }
}
