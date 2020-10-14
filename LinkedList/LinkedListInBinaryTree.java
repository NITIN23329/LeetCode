
// time O(nm) solution , auxilary space is O(m)
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null)return false;
        return isCheck(head,root)|| isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    private boolean isCheck(ListNode head, TreeNode root){
        if(head==null)return true;
        if(root==null)return false;
        if(head.val==root.val)
            return isCheck(head.next , root.left) || isCheck(head.next , root.right);
        return false;
    }
}
