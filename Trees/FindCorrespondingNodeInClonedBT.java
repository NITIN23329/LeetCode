/*
approach : time O(N) , space O(height)
 Traverse both the trees at same time and when reached the target node in origional tree, the corresponding node in the cloned tree is our answer.
*/
class Solution {
    TreeNode ans;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        traverse(original,target,cloned);
        return ans;
    }
    private void traverse(TreeNode i,TreeNode target,TreeNode j){
        if(i==null)return;
        if(i == target)ans = j;
        traverse(i.left,target,j.left);
        traverse(i.right,target,j.right);
    }
}
