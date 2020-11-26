// approach 1 : time : O(st)  , space O(s+t) : check for same strtucture of t for every node in s
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null || t==null)return s==null && t==null;
        if(isSame(s,t))return true;
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }
    private boolean isSame(TreeNode s , TreeNode t){
        if(s==null || t==null)return s==null && t==null;
        return s.val==t.val && isSame(s.left,t.left) && isSame(s.right,t.right);
    }
}
