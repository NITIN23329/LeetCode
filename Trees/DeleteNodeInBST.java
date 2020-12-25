//time = space = O(height)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)return null;
        if(root.val==key){
            if(root.left==null && root.right==null)root=null;
            else if(root.left!=null){
                root.val = findPrecedor(root.left);
                root.left = deleteNode(root.left ,root.val);
            }
            else{
                root.val = findSucessor(root.right);
                root.right = deleteNode(root.right,root.val);
            }
            return root;
        }
        if(root.val>key)
            root.left = deleteNode(root.left,key);
        else root.right = deleteNode(root.right,key);
        return root;
        
    }
    private int findPrecedor(TreeNode root){
        while(root.right!=null)root=root.right;
        return root.val;
    }
    private int findSucessor(TreeNode root){
        while(root.left!=null)root = root.left;
        return root.val;
    }
}
