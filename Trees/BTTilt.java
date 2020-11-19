//time O(N) , space O(height)
//find sum of left and right tree , subtract them to get tilt for current node.
//do this for all nodes in tree
class Solution {
    private int tilt;
    public int findTilt(TreeNode root) {
        tilt = 0;
        findSum(root);
        return tilt;
    }
    private int findSum(TreeNode root){
        if(root==null)return 0;
        int l = findSum(root.left);
        int r = findSum(root.right);
        tilt+=Math.abs(l-r);
        return root.val + l+r;
    }
}
