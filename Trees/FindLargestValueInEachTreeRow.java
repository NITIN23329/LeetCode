//iterative using queue (BFS) , time O(N) and space O(2^height)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)return max;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            int curr = Integer.MIN_VALUE;
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                curr = Math.max(curr,x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            max.add(curr);
        }
        return max;
    }
}
//recursive using DFS , time O(N) , space O(height)
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        find(root,list,0);
        return list;
    }
    private void find(TreeNode root,List<Integer> list,int level){
        if(root==null)return;
        if(list.size()==level)list.add(root.val);
        if(list.get(level)<root.val)list.set(level,root.val);
        find(root.left,list,level+1);
        find(root.right,list,level+1);
    }
}
