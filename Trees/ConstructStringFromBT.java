/*approach : 
1)add : root node 
2) if root.left!=null add : "(" + left subtree + ")" , else add:  "(" + ")" ,if we do not add "()" in later case we will get the tree wrong
3)if root.right != null , add : "(" + right subtree + ")" , otherwise we need not to add : "(" + ")"
*/
class Solution {
    public String tree2str(TreeNode root) {
       StringBuilder sb = new StringBuilder();
        if(root!=null)
            form(root,sb);
        return sb.toString();
    }
    private void form(TreeNode root , StringBuilder sb){
        sb.append(root.val);
        if(root.left==null && root.right==null)
            return;
        sb.append("(");
        if(root.left!=null)
            form(root.left,sb);
        sb.append(")");
        if(root.right!=null){
            sb.append("(");
            form(root.right,sb);
            sb.append(")");
        }
        
    }
}
