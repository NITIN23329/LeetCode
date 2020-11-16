//recursive solution , time O(n)
/* 
* if root < low , then our next eligible root is on its right subtree
* else if root > high , then next eligible root is on left subtree
* if no next eligible root found , return null
* else do this recursively for left and right subtree
*/
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null)return root;
        if(root.val<low)
            root = trimBST(root.right,  low , high);
        if(root==null)return root;
        if(root.val>high)
            root = trimBST(root.left , low , high);
        if(root==null)return root;
        root.right = trimBST(root.right,  low , high);
        root.left = trimBST(root.left,  low , high);
        return root;
   }
}
