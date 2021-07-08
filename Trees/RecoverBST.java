/*  time and space complexity : O(n)
    --> Store the inorder traveral of the tree.
    --> As nodes are swapped, the inorder traveral is not in sorted order.
    --> Find the nodes that are not in correct place in the inorder and swap their values.
    --> There can be 2 cases, either we swapped nodes in the left and right subtree of a node or we swapped the node with one if its children. 
*/
class Solution {
    List<TreeNode> in = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        TreeNode x = null,y = null;
        inOrder(root);
        for(int i=0;i<in.size()-1;i++){
            if(in.get(i).val>in.get(i+1).val){
                if(x==null){
                    x = in.get(i);
                    y = in.get(i+1);
                }
                else y = in.get(i+1);
            }
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        in.add(root);
        inOrder(root.right);
    }
}
// we can reduce the space complexity to O(1).
/*
  --> we dont need the whole inorder traversal at a time, we need a node and either its previous or next node in inorder traversal.
  --> We can get the previous node in the inorder traversal and then can check just like we did in above solution. 
*/
class Solution {
    TreeNode x = null,y = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
    private void inOrder(TreeNode curr){
        if(curr==null)return;
        inOrder(curr.left);
        if(prev != null){
            if(prev.val > curr.val){
                if(x==null){
                    x = prev;
                    y = curr;
                }else y = curr;
            }
        }
        prev = curr;
        inOrder(curr.right);
    }
}
