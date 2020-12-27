//time O(n) ,  space o(n) 
// use in order to get sorted tree and update links to form a linkedList
class Solution {
    private ArrayList<TreeNode>  list;
    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        for(int i=0;i<list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
            
        return list.get(0);
    }
    private void inOrder(TreeNode x){
        if(x==null)return;
        inOrder(x.left);
        list.add(x);
        inOrder(x.right);
    }
}
//time O(n) , space O(height)
// keep hold of previously visited node, while doing inorder, update the refrence of previous node and make current node as previous and goto next node.
// one thing is to make the left and right of last visited node be null cuz of case : it will create a cycle if not done so.
/*                                                                              2
                                                                               / \
                                                                              1   5
                                                                                 /
                                                                                4
                                                                               /
                                                                              3
*/
class Solution {
    TreeNode prev;
    TreeNode nr;
    public TreeNode increasingBST(TreeNode root) {
        prev = null;nr=null;
        inOrder(root);
        prev.left=null;
        return nr;
        
    }
    private void inOrder(TreeNode root){
        if(root==null)return;
        inOrder(root.left);
        if(prev!=null){
            prev.right = root;
            prev.left = null;
        }else nr=root;
        prev = root;
        inOrder(root.right);
    }
}
