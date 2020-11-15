//recursive : time complexity O(N) , space O(height)
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
//iterative : ime complexity O(N) , space O(2^height)
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return 0;
        q.add(root);
        q.add(null);
        int c = 1;
        while(q.size()!=1){
            TreeNode x = q.poll();
            if(x==null){
                c++;q.add(null);
            }
            else{
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
        }
        return c;
    }
}
