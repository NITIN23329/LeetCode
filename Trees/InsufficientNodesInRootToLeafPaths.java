// time complexity O(n) , space complexity O(height)
/*  approach : 
      --> do a preorder traversal.
      --> for every path from root to leaf, find path sum
      --> if path sum < limit, we need to remove that path.
      --> if we are at leaf node and sum<limit ,then return null else return leaf.
      --> for non leaf nodes, find left and right subtree, if both left and right subtree are null , 
              then it means both left and right paths to children is insufficent, in that case return null else return non leaf node.
*/
class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return preOrder(root,0,limit);
    }
    private TreeNode preOrder(TreeNode root,int curr,int limit){
        if(root==null)return null;
        curr+=root.val;
        if(root.left==null && root.right==null){
           return curr<limit? null : root;
        }
        root.left = preOrder(root.left,curr,limit);
        root.right = preOrder(root.right,curr,limit);
        return root.left==root.right ? null : root;
        
    }
}
