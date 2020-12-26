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
