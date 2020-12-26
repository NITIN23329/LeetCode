// time O(n) ,space O(height)
// find each path from root to leaf and add to result when we found leaf node
class Solution {
    int res;
    public int sumNumbers(TreeNode root) {
        res=0;
        findSum(root,0);
        return res;
    }
    private void findSum(TreeNode root,int curr){
        if(root==null)return;
        curr = curr*10 + root.val;
        if(root.left==null && root.right==null){
            res+=curr;
        }
        findSum(root.left,curr);
        findSum(root.right,curr);
        curr/=10;
    }
}
