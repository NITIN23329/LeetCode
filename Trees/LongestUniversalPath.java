//time O(N) , space O(height)
/*  approach :
      --> there are 2 conditions , either node has a value what we are looking for or not (val)
          -->if node.val==val ,find the maximum path passing through current node, then return 1 + max(left path , right path) for calculation of parent node
          -->else call for the this node's value find the maximum path for it and return 0 to parent node as parent.val!=node.val
*/
class Solution {
    int res;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)return 0;
        res=0;
        length(root,root.val);
        return res-1;
    }
    private int length(TreeNode root, int val){
        if(root==null)return 0;
        if(root.val!=val){
            int x = length(root,root.val);
            res = Math.max(res,x);
            return 0;
        }
        else {
            int l = length(root.left,val);
            int r = length(root.right,val);
            res=Math.max(res,1+l+r);
            return 1 + Math.max(l,r);
        }
    }
}
