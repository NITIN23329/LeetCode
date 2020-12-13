// find the maximum seen while coming to each node  
// if the current node value >= max seen , then this node is an answer
//recursively find for left and right subtree.
class Solution {
    public int goodNodes(TreeNode root) {
       return  find(root,Integer.MIN_VALUE);
    }
    private int find(TreeNode root , int curr){
        if(root==null)return 0;
        int c=0;
        if(root.val>=curr)c++;
        curr = Math.max(root.val,curr);
        c+=find(root.left,curr)+find(root.right,curr);
        return c;
    }
}
