//time O(n) , space O(height)
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
