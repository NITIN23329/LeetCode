//time O(n^2) for worst case , space O(height)
             1
           /  \
          2    2
         / \  / \
        3  3 3   3.    in this, both filped and not fliped conditions are true .
/* approach :
  --> if root1.val != root2.val return false
  --> if any root is null then other root has to be null
  --> check for both cases if fliped or if not fliped
*/
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null)return root2==root1;
        if(root1.val!=root2.val)return false;
        return (flipEquiv(root1.left,root2.left) && 
                flipEquiv(root1.right,root2.right))||
            (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left));
        
    }
}
// time O(N) actual solution :
/* approach :
  --> if the nodes are flipped , reverse the flip
    --> 1st case is when left nodes are not of equal value
    --> another case is when either root1.left==null and root2.left!=null or root1.left!=null and root2.left==null
*/
class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null)return root2==root1;
        if(root1.val!=root2.val)return false;
        if((root1.left==null&&root2.left!=null)||(root2.left==null&&root1.left!=null)
           || (root1.left!=null&&root2.left!=null&&root1.left.val!=root2.left.val)){ 
            // flipped condition so swap both left and right subtree
            TreeNode l = root2.left;
            root2.left = root2.right;
            root2.right=l;
        }
        return flipEquiv(root1.left,root2.left)&& flipEquiv(root1.right,root2.right);

        
    }
}
