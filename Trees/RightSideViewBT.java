//iterative level order, find the rightmost node for every level
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            list.add(q.peek().val);
            for(int i=0;i<s;i++){
                TreeNode x = q.poll();
                if(x.right!=null)q.add(x.right);
                if(x.left!=null)q.add(x.left);
            }
        }
        return list;
    }
}
//recursive reverse preorder traversal
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        find(root,0,list);
        return list;
    }
    private void find(TreeNode root,int level,List<Integer> list){
        if(root==null)return;
        if(list.size()==level)list.add(root.val);
        find(root.right,level+1,list);
        find(root.left,level+1,list);
    }
}
