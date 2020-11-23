//recursive , O(N) time  ,  O(height) space;
class Solution {
    public int minDepth(TreeNode root) {
        return root==null ? 0 :find(root);
    }
    private int find(TreeNode root){
        if(root.left==null && root.right==null)
            return 1;
        int l = Integer.MAX_VALUE;
        if(root.left!=null)
            l = find(root.left);
        int r = Integer.MAX_VALUE;
        if(root.right!=null)
            r = find(root.right);
        return 1 + Math.min(l,r);
    }
}
// iterative level order, faster than recursion. time O(N) , space O(2^height)
// as soon as we found first leaf during level order traversal we stop. but in recursion, we go to every node for sure.
class Solution {
    public int minDepth(TreeNode root) {
        int ans = 0;
        if(root==null)return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ans++;
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                if(x.left==null && x.right==null)return ans;
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            ans++;
        }
        return -1;
    }
}
