//iterative : BFS/level order
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int curr = 0;
            while(s-->0){
                TreeNode x = q.poll();
                curr+=x.val;
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            ans = curr;
        }
        return ans;
    }
}
//recursive : DFS
class Solution {
    private int deep;
    private int sum;
    public int deepestLeavesSum(TreeNode root) {
        sum=0;
        deep=-1;
        findSum(root,0);
        return sum;
    }
    public void findSum(TreeNode root,int depth){
        if(root==null)return;
        if(deep ==depth)
            sum+=root.val;
        if(deep<depth){
            sum = root.val;
            deep = depth;
        }
        findSum(root.left,depth+1);
        findSum(root.right,depth+1);
    }
}
