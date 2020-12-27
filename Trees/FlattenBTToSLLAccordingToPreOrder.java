//time O(n) , space O(n)
//store the preorder traversal in a map or in an array
// then update the tree
class Solution {
    Map<Integer,TreeNode> map;
    int ind;
    public void flatten(TreeNode root) {
        map = new HashMap<>();
        ind=0;
        preOrder(root);
        for(int i=0;i<map.size()-1;i++){
            TreeNode x = map.get(i);
            TreeNode y = map.get(i+1);
            x.right = y;
            x.left = null;
        }
    }
    private void preOrder(TreeNode root){
        if(root==null)return;
        map.put(ind++,root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
//time O(n) , space O(height)
// during preorder traversal , keep hold of previously visited node, update refrence of the previous node
class Solution {
    private TreeNode prev;      //keep hold of previously visited node
    private TreeNode nr;        // new root
    public void flatten(TreeNode root) {
        prev = null;
        preOrder(root);
        root = nr;
    }
    private void preOrder(TreeNode root){
        if(root==null)return;
        TreeNode r=root.right;      //store the right node cuz, the reference will be deleted btw root and root.right due to prev.right change 
        if(prev!=null){
            prev.right = root;      //updating refrence of previouly visited node
            prev.left = null;
        }else {
            nr = root;
        }
        prev = root;
        preOrder(root.left);
        preOrder(r);
    }
}
