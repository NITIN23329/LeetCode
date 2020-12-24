//iterative level order using queue
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                level.add(x.val);
                if(x.left!=null)q.add(x.left);
                if(x.right!=null)q.add(x.right);
            }
            list.add(level);
        }
        return list;
    }
}
//time O(N) , using recursive preorder traversal
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helpr(root,0,list);
        return list;
    }
    private void helpr(TreeNode root,int level,List<List<Integer>> list){
        if(root==null)return;
        if(level==list.size())list.add(new ArrayList<>());
        list.get(level).add(root.val);
        helpr(root.left,level+1,list);
        helpr(root.right,level+1,list);
    }
}
