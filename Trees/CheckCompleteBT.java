// if we find a null first and then a not null node during the level order traversal, then it is not a CBT
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean isNull = false;
        q.add(root);
        while(!q.isEmpty()){
            TreeNode x = q.poll();
            if(x.left!=null){
                if(isNull)return false;
                q.add(x.left);
            }else isNull = true;
            if(x.right!=null){
                if(isNull)return false;
                q.add(x.right);
            }else isNull = true;
        }
        return true;
    }
}
