//iterative using queue time O(n), space O(2^height)
//approach find the lest most node of last level
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res=-1;
        while(!q.isEmpty()){
            int s = q.size();
            res = q.peek().val;
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
        return res;
    }
}
