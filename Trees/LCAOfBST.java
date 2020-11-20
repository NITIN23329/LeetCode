// as we are given a BST , try to make use of it.
// as we are given that both nodes are present , so no need to check for its presence.
//approach :
/* 
*start from root node
* if root is one of the 2 nodes  , root is the LCA
* if the root node's value is in between the 2 node's value , LCA will be root
* if both nodes are > root  , go to right subtree
* if both nodes are < root . go to left subree
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return root;
        if(root==p || root==q)return root;
        if(root.val>p.val && root.val < q.val)return root;
        if(root.val>q.val && root.val < p.val)return root;
        if(root.val> p.val)
            return lowestCommonAncestor(root.left , p,q);
        return lowestCommonAncestor(root.right,p,q);
    }
}
