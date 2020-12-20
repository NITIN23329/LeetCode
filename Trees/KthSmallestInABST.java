//time O(n) , space O(height)
/*  approach :
    --> do inOrder traversal , whenever we visit a node , we update our counter
    --> when counter == k , we get our result
*/
class Solution {
    int c;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {
        c=0;
        inOrder(root,k);
        return res.val;
        
    }
    private void inOrder(TreeNode root,int k){
        if(root==null || c>k)return;
        inOrder(root.left,k);
        c++;
        if(c==k)res = root;
        inOrder(root.right,k);
    }
   
}
